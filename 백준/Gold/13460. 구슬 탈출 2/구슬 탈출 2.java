import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;

    static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dy = { 0, 0, -1, 1 };

    static class Ball{
        int rx, ry, bx, by, depth;

        Ball(int rx, int ry, int bx, int by, int depth){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx=0, ry=0, bx=0, by=0;

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='R'){
                    rx = i;
                    ry = j;
                }else if(map[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by){
        Queue<Ball> q = new LinkedList<>();
        q.add(new Ball(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while(!q.isEmpty()){
            Ball curr = q.poll();

            if(curr.depth>=10) return -1;

            for(int d=0;d<4;d++){
                int[] nextR = move(curr.rx, curr.ry, d);
                int[] nextB = move(curr.bx, curr.by, d);

                int nRx = nextR[0], nRy = nextR[1];
                int nBx = nextB[0], nBy = nextB[1];
                boolean redHole = nextR[2] == 1;
                boolean blueHole = nextB[2] == 1;

                if(blueHole) continue;
                if(redHole) return curr.depth + 1;

                // 겹침 처리
                if(nRx==nBx&&nRy==nBy) {
                    if (nextR[3] > nextB[3]) { // R이 더 많이 이동했으면 뒤로 한 칸
                        nRx -= dx[d];
                        nRy -= dy[d];
                    } else {
                        nBx -= dx[d];
                        nBy -= dy[d];
                    }
                }

                if (!visited[nRx][nRy][nBx][nBy]) {
                    visited[nRx][nRy][nBx][nBy] = true;
                    q.add(new Ball(nRx, nRy, nBx, nBy, curr.depth + 1));
                }
            }
        }

        return -1;
    }

    // move: [0] x, [1] y, [2] hole 여부(1이면 빠짐), [3] 이동 거리
    static int[] move(int x, int y, int d) {
        int cnt = 0;
        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (map[nx][ny] == '#') break;
            if (map[nx][ny] == 'O') return new int[] { nx, ny, 1, cnt + 1 };

            x = nx;
            y = ny;
            cnt++;
        }
        return new int[] { x, y, 0, cnt };
    }
}

