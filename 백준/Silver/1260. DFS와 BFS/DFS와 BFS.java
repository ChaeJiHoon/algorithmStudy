import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int N,M,V;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=0;i<=N;i++) map[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for(int i=0;i<=N;i++) Collections.sort(map[i]);

        dfs(V);

        visited = new boolean[N+1];
        sb.append("\n");
        bfs(V);

        System.out.println(sb.toString().trim());
    }

    static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for(int node : map[start]){
            if(!visited[node]) dfs(node);
        }
    }

    static void bfs(int start){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!q.isEmpty()){
            int num = q.poll();

            for(int node : map[num]){
                if(!visited[node]) {
                    visited[node] = true;
                    sb.append(node).append(" ");
                    q.add(node);
                }
            }
        }

    }
}
