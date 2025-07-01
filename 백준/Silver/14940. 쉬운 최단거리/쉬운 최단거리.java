import java.util.*;
import java.io.*;

public class Main {
    static int[][] originMap;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int N;
    static int M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originMap = new int[N][M];
        visited = new boolean[N][M];

        int[] start = new int[2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int place = Integer.parseInt(st.nextToken());
                originMap[i][j] = place;
                if(place==2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        bfs(start);

        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (originMap[i][j] == 1 && !visited[i][j]) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(originMap[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }


        System.out.println(sb.toString().trim());
    }

    static void bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        originMap[start[0]][start[1]] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            visited[y][x] = true;


            for(int i=0;i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];

                if(newX>=0 && newY>=0 && newX<M && newY<N && originMap[newY][newX]==1 && !visited[newY][newX]){
                    q.add(new int[]{newY,newX});
                    originMap[newY][newX] = originMap[y][x]+1;
                }
            }
        }

    }
}
