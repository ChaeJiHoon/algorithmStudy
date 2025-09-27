import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1,-1,-1,0,1,1,1,0};
    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static int w,h;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0){
                System.out.print(sb);
                return;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
            
            int cnt = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visited[i][j] && map[i][j]==1){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            
            sb.append(cnt).append("\n");
        }
    }

    static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int k=0;k<8;k++){
                int nI = cur[0]+dy[k];
                int nJ = cur[1]+dx[k];

                if(nI<0 || nJ<0 || nI>=h || nJ>=w || visited[nI][nJ] || map[nI][nJ]==0) continue;
                visited[nI][nJ] = true;
                q.add(new int[]{nI,nJ});
            }
        }
    }
}
