package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS {
    static boolean[] dfs_visit;
    static boolean[] bfs_visit;
    static int[][] dfs_map;
    static int[][] bfs_map;

    static Queue<Integer> dfs_q = new LinkedList<>();
    static Queue<Integer> bfs_q = new LinkedList<>();

    static int n;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        dfs_visit = new boolean[n+1];
        bfs_visit = new boolean[n+1];

        dfs_map = new int[n+1][n+1];
        bfs_map = new int[n+1][n+1];

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dfs_map[a][b] = 1;
            dfs_map[b][a] = 1;
            bfs_map[a][b] = 1;
            bfs_map[b][a] = 1;
        }

        // dfs 구현부
        dfs(v);

        for(int i=1;i<=n;i++){
            if(!dfs_visit[i]){
                for(int j=1;j<=n;j++){
                    if(dfs_map[i][j] == 1) dfs(i);
                }
            }
        }

        int length = dfs_q.size();

        for (int i=0;i<length;i++) {
            System.out.print(dfs_q.poll()+" ");
        }

        // bfs 구현부

    }

    static void dfs(int num){
        if(dfs_visit[num]) return;
        dfs_visit[num] = true;
        dfs_q.add(num);
        for(int i=0;i<dfs_visit.length;i++){
            if(dfs_map[num][i] == 1 && !dfs_visit[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int num, int x,int y){
        if(bfs_visit[num]) return;
        bfs_visit[num] = true;
        bfs_q.add(num);
        for(int i=0;i<4;i++){
            int nextX = dx[i]+x;
            int nextY = dy[i]+y;
            if(0<nextX && 0<nextY && nextX<=n && nextY<=n
               && bfs_map[nextX][nextY]==1){
                //bfs()
            }
        }
    }
}
