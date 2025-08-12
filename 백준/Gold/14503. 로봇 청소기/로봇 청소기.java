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

            if(hasDirty){
                // 왼쪽부터 4번 탐색
                int nd = dir;
                for (int i = 0; i < 4; i++) {
                    nd = direction(nd); // 왼쪽으로 회전
                    int ny = y+dy[nd];
                    int nx = x+dx[nd];
                    if(ny<0||nx<0||ny>=n||nx>=m) continue;

                    // 청소 안 된 칸 발견 -> 그 칸으로 전진(방향은 nd 유지)
                    if(map[ny][nx]==0){
                        q.add(new int[]{ny, nx, nd});
                        break;
                    }

                    // 못 가면 다음 회전
                    if(i==3){
                        // 네 방향 모두 못 갔으면, 바로 뒤로 가보기 (아래 else 분기와 동일 결과)
                        int back = (dir+2)%4;     //  이게 킥
                        int by = y+dy[back];
                        int bx = x+dx[back];
                        if (by<0||bx<0||by>=n||bx>=m||map[by][bx] == 1) return; // 뒤가 벽이면 종료
                        q.add(new int[]{by, bx, dir}); // 방향 유지하고 후진
                    }
                }
            } else {
                // 2. 주변에 청소할 칸이 없으면 후진 (벽만 아니면 가능)
                int back = (dir+2)%4;
                int ny = y + dy[back];
                int nx = x + dx[back];
                if (ny<0 || nx<0 || ny>=n || nx>=m || map[ny][nx] == 1) {
                    // 뒤가 벽이면 멈춤
                    return;
                }
                q.add(new int[]{ny, nx, dir}); // 방향 유지하고 후진
            }
        }
    }

    // 왼쪽 회전: 0→3→2→1→0
    static int direction(int nowDirection){
        if(nowDirection==0) return 3;
        else return nowDirection-1;
    }
}
