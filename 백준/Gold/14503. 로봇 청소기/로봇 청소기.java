import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int n,m,r,c,d;
    static int[] dy = {-1, 0, 1, 0};    // 방향: 0북,1동,2남,3서
    static int[] dx = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) map[i][j] = Integer.parseInt(st.nextToken()); // ★ j<m 로 수정
        }

        bfs();
        System.out.println(cnt);
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c,d});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int dir = cur[2];

            // 0. 현재 칸 청소
            if (map[y][x] == 0) {
                map[y][x] = -1;
                cnt++;
            }

            // 1. 주변에 청소할 칸(0)이 있는지 확인
            boolean hasDirty = false;
            for(int k=0;k<4;k++){
                int ny = y+dy[k];
                int nx = x+dx[k];
                if(ny<0||nx<0||ny>=n||nx>=m) continue;
                if(map[ny][nx] == 0) {hasDirty = true; break;}
            }

            //왼쪽부터 4방향 탐색하여 청소할 곳 찾기
            boolean moved = false;
            int nd = dir;
            for (int t = 0; t < 4; t++) {
                nd = direction(nd);                 // 왼쪽으로 회전
                int ny = y + dy[nd], nx = x + dx[nd];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[ny][nx] == 0) {            // 아직 청소 안 된 칸 발견
                    q.add(new int[]{ny, nx, nd});  // 그쪽으로 전진
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                // 2) 네 방향 모두 못 갔으면 후진 (방향 유지)
                int back = (dir + 2) % 4;
                int by = y + dy[back], bx = x + dx[back];
                if (by < 0 || bx < 0 || by >= n || bx >= m || map[by][bx] == 1) {
                    // 뒤가 벽이면 작동 종료
                    return;
                }
                q.add(new int[]{by, bx, dir}); // 후진 (방향 유지)
            }
        }
    }

    // 왼쪽 회전: 0→3→2→1→0
    static int direction(int nowDirection){
        if(nowDirection==0) return 3;
        else return nowDirection-1;
    }
}
