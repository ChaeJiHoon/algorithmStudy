package dfs;
// 백준 | DFS+BFS | 실버2
// 1260 번 : ATM
// 시간 제한 : 2초, 메모리 제한 : 256 MB
// 25.05.26
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS {
    static int n;
    static int m;
    static int v;
    static int[][] dfsMap;
    static int[][] bfsMap;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static Queue<Integer> dfsQ = new LinkedList<>();
    static Queue<Integer> bfsQ = new LinkedList<>();
    static Queue<Integer> bfsQ2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sbDfs = new StringBuilder();
        StringBuilder sbBfs = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        dfsMap = new int[n+1][n+1];
        bfsMap = new int[n+1][n+1];
        dfsVisited = new boolean[n+1];
        bfsVisited = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dfsMap[a][b] = 1;
            bfsMap[a][b] = 1;
            dfsMap[b][a] = 1;
            bfsMap[b][a] = 1;
        }

        dfs(v);         // dfs 시작
        int dfsL = dfsQ.size();
        for(int i=0;i<dfsL;i++){
            if(i==dfsL-1) sbDfs.append(dfsQ.poll());
            else sbDfs.append(dfsQ.poll()).append(" ");
        }

        // bfs 시작
        bfsQ.add(v);
        bfsQ2.add(v);
        bfs(bfsQ.poll());
        int bfsL = bfsQ2.size();
        for(int i=0;i<bfsL;i++){
            if(i==bfsL-1) sbBfs.append(bfsQ2.poll());
            else sbBfs.append(bfsQ2.poll()).append(" ");
        }

        System.out.println(sbDfs.toString());
        System.out.println(sbBfs.toString());
    }

    private static void dfs(int v) {
        dfsVisited[v] = true;                       // 방문 처리
        dfsQ.add(v);                                // 큐에 넣음
        for(int i=1;i<=n;i++){                       // 방문할 노드가 있는지 순회
            if(dfsMap[v][i]==1 && !dfsVisited[i]) dfs(i);
        }
    }


    private static void bfs(int v) {
        bfsVisited[v] = true;                       // 방문 처리
        for(int i=1;i<=n;i++){                      // 방문할 노드가 있는지 순회
            if(bfsMap[v][i]==1 && !bfsVisited[i]) {
                bfsVisited[i] = true;
                bfsQ.add(i);
                bfsQ2.add(i);
            }
        }
        if(!bfsQ.isEmpty()) bfs(bfsQ.poll());
    }
}
