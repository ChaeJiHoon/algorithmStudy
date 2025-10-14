import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] node;
    static int V, E;
    static boolean trigger;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            trigger = true;
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V+1];
            node = new int[V+1];
            for(int i=0;i<=V;i++) graph[i] = new ArrayList<>();

            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                graph[to].add(from);
            }

            for(int i=1;i<=V && trigger;i++) if(node[i]==0) dfs(1,i);

            sb.append(trigger ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int color, int cur){
        if(!trigger) return;
        if(node[cur]==0){
            node[cur] = color;
            int nextColor = (color==1) ? -1 : 1;

            for(int next : graph[cur]){
                dfs(nextColor, next);
                if(!trigger) return;
            }
        }else if(node[cur] != color) trigger = false;
    }
}