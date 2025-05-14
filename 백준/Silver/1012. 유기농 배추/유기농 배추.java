import java.util.Scanner;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        // map 배추 심기
        for(int k=0;k<testCase;k++){
            int[][] map;
            //가로
            int M = sc.nextInt();
            //세로
            int N = sc.nextInt();
            map = new int[N][M];
            visited = new boolean[N][M];
            int cabbage = sc.nextInt();
            int worm = 0;

            // 이 반복문을 통해 테스트 케이스 하나당 배추 맵 완료
            for(int i=0;i<cabbage;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[y][x] = 1;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j]==1){
                        dfs(i,j,M,N,map);
                        worm++;
                    }
                }

            }
            System.out.println(worm);
        }

    }

    static void dfs(int i,int j,int M,int N, int[][] map){
        visited[i][j] = true;

        for(int k=0;k<4;k++){
            int ni = i+dy[k];
            int nj = j+dx[k];
            if(ni>=0 && nj>=0 && ni<N && nj < M
                    && !visited[ni][nj] && map[ni][nj]==1){
                dfs(ni,nj,M,N,map);
            }
        }
    }
}
