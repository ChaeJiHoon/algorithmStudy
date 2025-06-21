package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SearchTreeParent {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        // 인접 리스트 초기화
        for(int i=1;i<=N;i++) tree[i] = new ArrayList<>();

        // 간선 정보 입력
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);

        for(int i=2;i<=N;i++) sb.append(parent[i]).append("\n");

        System.out.println(sb.toString().trim());

    }

    static void dfs(int now){
        visited[now] = true;
        for(int next : tree[now]){
            if(!visited[next]){
                parent[next] = now;// 현재 노드가 next의 부모
                dfs(next);
            }
        }
    }
}
