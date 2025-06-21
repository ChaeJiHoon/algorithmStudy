import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] map;
    static boolean[][][] visited;
    static int M,N,H;
    static Queue<int[]> q = new LinkedList<>();

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[] dh = {-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        
        int cntTomato=0;

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k]==1) {
                        q.add(new int[]{i,j,k});
                        cntTomato++;
                    }
                }
            }
        }
        
        if(cntTomato==0) System.out.println(-1);
        else System.out.println(bfs());

    }

    static int bfs(){
        if(q.isEmpty()) return 0;

        while(!q.isEmpty()){
            int[] ar = q.poll();
            int h = ar[0];
            int n = ar[1];
            int m = ar[2];

            for(int i=0;i<4;i++){
                int nx = m+dx[i];
                int ny = n+dy[i];
                if(nx>=0 && ny>=0 && nx<M && ny<N && map[h][ny][nx]==0) {
                    map[h][ny][nx] = map[h][n][m]+1;
                    q.add(new int[]{h,ny,nx});
                }
            }
            for(int i=0;i<2;i++){
                int nh = h+dh[i];
                if(nh>=0 && nh<H && map[nh][n][m]==0) {
                    map[nh][n][m] = map[h][n][m]+1;
                    q.add(new int[]{nh,n,m});
                }
            }

        }

        return check();
    }

    static int check(){
        int max = 0;
        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++) {
                    max = Math.max(map[i][j][k],max);
                    if(map[i][j][k]==0) return -1;
                }
            }
        }
        return max-1;
    }

}
