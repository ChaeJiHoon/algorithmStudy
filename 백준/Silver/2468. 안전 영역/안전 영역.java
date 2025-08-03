import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, max=0, answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
            }
        }

        for(int i=0;i<=max;i++){
            flood(i);
            count();
        }

        System.out.println(answer);

    }

    static void flood(int num){
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) if(map[i][j] <= num) visited[i][j] = true;
        }
    }

    static void count(){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                if(!visited[i][j]) {
                    cnt++;
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int curY = cur[0];
                        int curX = cur[1];

                        for(int k=0;k<4;k++){
                            int newY = curY+dy[k];
                            int newX = curX+dx[k];

                            if(newX>=0 && newY>=0 && newX<N && newY<N && !visited[newY][newX]){
                                q.add(new int[]{newY,newX});
                                visited[newY][newX] = true;
                            }
                        }
                    }
                }
            }
        }
        answer = Math.max(answer,cnt);
    }
}