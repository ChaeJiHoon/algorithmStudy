import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N;
    static int[] bS; 
    static int[] dx = {0,-1,1,0};  // 상,좌,우,하 순
    static int[] dy = {-1,0,0,1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    map[i][j] = 0;
                    bS = new int[]{i,j,2,0}; // y,x, size, eaten
                }
            }
        }

        while(bfs());
        System.out.print(cnt);
    }

    static boolean bfs(){
        int[][] dist = new int[N][N];
        for (int i=0;i<N;i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{bS[0], bS[1]});
        dist[bS[0]][bS[1]] = 0;

        int minDist = -1;
        int targetY = -1, targetX = -1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1];
            int cd = dist[cy][cx];

            if (minDist != -1 && cd > minDist) continue;

            for(int dir=0; dir<4; dir++){
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];
                if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
                if(dist[ny][nx] != -1) continue;
                if(map[ny][nx] > bS[2]) continue;

                dist[ny][nx] = cd + 1;

                // 먹을 수 있는 물고기
                if(map[ny][nx] != 0 && map[ny][nx] < bS[2]){
                    int d = dist[ny][nx];
                    if (minDist==-1||d<minDist){
                        // 더 가까운 먹이를 처음 발견
                        minDist = d;
                        targetY = ny;
                        targetX = nx;
                    } else if (d == minDist) {
                        // 동거리 => 위쪽, 왼쪽 우선
                        if (ny < targetY || (ny == targetY && nx < targetX)){
                            targetY = ny;
                            targetX = nx;
                        }
                    }
                }

                // 다음 확장
                q.add(new int[]{ny, nx});
            }
        }

        if (minDist == -1) return false; // 먹을 물고기 없음

        cnt += minDist;
        bS[0] = targetY;
        bS[1] = targetX;
        map[targetY][targetX] = 0;

        bS[3]++; 
        if(bS[3] == bS[2]){
            bS[2]++;    
            bS[3] = 0; 
        }
        return true;
    }
}
