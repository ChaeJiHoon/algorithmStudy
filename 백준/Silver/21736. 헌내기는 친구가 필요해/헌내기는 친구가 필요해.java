import java.io.*;
import java.util.*;

public class Main {
    static String[][] map;
    static boolean[][] visited;
    static int N,M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int people = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M];

        int startY=0, startX=0;
        for(int i=0;i<N;i++) {
            map[i] = br.readLine().split("");
            for(int j=0;j<M;j++){
                if(map[i][j].equals("I")){
                    startY = i;
                    startX = j;
                }
            }
        }
        System.out.println(bfs(startY,startX));
    }

    static String bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            if(map[arr[0]][arr[1]].equals("P")) people++;

            for(int i=0;i<4;i++){
                int nY = arr[0]+dy[i];
                int nX = arr[1]+dx[i];

                if(nY>=0 && nX >= 0 && nY<N && nX<M && !map[nY][nX].equals("X") && !visited[nY][nX]){
                    visited[nY][nX] = true;
                    q.add(new int[]{nY,nX});
                }
            }
        }
        return people==0 ? "TT" : ""+people;
    }


}
