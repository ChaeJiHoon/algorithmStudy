import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {
            {1,2},{2,1},{1,-2},{2,-1},
            {-1,2},{-2,1},{-1,-2},{-2,-1}
    };
    static int targetX, targetY, l;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            bfs(nowX, nowY);
        }

        System.out.println(sb);
    }

    static void bfs(int nX, int nY){

        if(nY==targetY && nX==targetX){
            sb.append(0).append("\n");
            return;
        }

        map = new int[l+1][l+1];
        visited = new boolean[l+1][l+1];
        Queue<int[]> q = new LinkedList<>();
        map[nY][nX] = 0;
        q.add(new int[]{nX,nY});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<8;i++){
                int newX = cur[0]+dir[i][0];
                int newY = cur[1]+dir[i][1];

                if(newX<0 || newY<0 || newX>=l || newY>=l || visited[newY][newX]) continue;
                if(newY==targetY && newX==targetX){
                    sb.append(map[cur[1]][cur[0]]+1).append("\n");
                    return;
                }
                visited[newY][newX] = true;
                map[newY][newX] = map[cur[1]][cur[0]]+1;
                q.add(new int[]{newX, newY});
            }
        }
    }
}