import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean cycle = false;
    static int[] state;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for (int i=1;i<=N;i++) graph[i] = new ArrayList<>();

        for(int i=1;i<N;i++){
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) graph[i].add(Integer.parseInt(st.nextToken()));
        }

        state = new int[N+1];
        dfs(1);

        System.out.println(cycle ? "CYCLE" : "NO CYCLE");
    }

    static void dfs(int n){
        if(cycle) return;   
        state[n] = 1;        
        for(int v : graph[n]){
            if (state[v] == 0) dfs(v);
            else if(state[v] == 1){
                cycle = true;
                return;
            }
        }
        state[n] = 2;           
    }
}
