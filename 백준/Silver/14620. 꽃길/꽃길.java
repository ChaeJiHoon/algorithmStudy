import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N,min=Integer.MAX_VALUE;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0);

        System.out.println(min);

    }

    static void backTracking(int depth, int sum){
        if(depth>=3){
            min = Math.min(min, sum);
            return;
        }

        for(int i=1;i<N-1;i++){

            for(int j=1;j<N-1;j++) {
                // 하나라도 방문 되어 있으면 넘어감
                if(trigger(j,i)) continue;
                int num = 0;
                num += check(j,i,true,sum);
                backTracking(depth+1,num);
                check(j,i,false,sum);

            }
        }

    }

    static boolean trigger(int x, int y){
        if(visited[y][x]) return true;
        for(int i=0;i<4;i++){
            int nX = x+dx[i];
            int nY = y+dy[i];
            if(visited[nY][nX]) return true;
        }
        return false;
    }

    static int check(int x, int y, boolean trigger, int sum){
        visited[y][x] = trigger;
        if(trigger) sum += map[y][x];

        for(int i=0;i<4;i++){
            int nX = x+dx[i];
            int nY = y+dy[i];
            visited[nY][nX] = trigger;
            if(trigger) sum += map[nY][nX];
        }

        return sum;
    }
}
