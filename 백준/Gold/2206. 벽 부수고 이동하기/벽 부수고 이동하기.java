import java.io.*;
import java.util.*;

public class Main {

    static int N,M, min=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == 1 && M == 1) { System.out.println(1); return; }

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            String[] num = br.readLine().split("");
            for(int j=0;j<M;j++) map[i][j] = Integer.parseInt(num[j]);
        }

        func();

        if(!visited[N-1][M-1][0] && !visited[N-1][M-1][1]) System.out.println(-1);
        else System.out.println(min);
    }

    static void func(){
        Queue<int[]> q = new LinkedList<>();

        // x,y,토큰,거리
        q.add(new int[]{0,0,1,1});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowT = now[2];
            int nowD = now[3];

            for(int i=0;i<4;i++){
                int newX = nowX+dx[i];
                int newY = nowY+dy[i];
                int newT = nowT;
                int newD = nowD+1;

                if(newX<0 || newY<0 || newX>=M || newY>=N) continue;
                if(map[newY][newX]==1){
                    if(newT==1) newT--;
                    else continue;
                }
                // 벽을 부순적이 없지만 방문한적 있음
                if(newT==1 && visited[newY][newX][1]) continue;
                if(newT==0 && visited[newY][newX][0]) continue;

                // 최단 경로 기록
                if(newY==N-1 && newX==M-1) min = Math.min(min, newD);
                visited[newY][newX][newT] = true;
                q.add(new int[]{newX,newY,newT,newD});
            }
        }
    }
}