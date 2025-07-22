import java.util.*;
import java.io.*;

public class Main{

    static int N,K;
    static List<Integer>[] graph;
    static int[] time;
    static int[] dp;
    static int[] indegree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            indegree = new int[N+1];
            time = new int[N+1];
            dp = new int[N+1];

            for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++) {
                time[i] = Integer.parseInt(st.nextToken());
                dp[i] = time[i];
            }

            for(int i=1;i<=K;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                indegree[to]++;
            }


            int num = Integer.parseInt(br.readLine());
            topologicalSort();
            sb.append(dp[num]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();

        // 진입 차수 0인 노드부터 시작
        for(int i=1;i<=N;i++){
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : graph[now]){
                dp[next] = Math.max(dp[next],dp[now]+time[next]);    // 갈 노드의 dp vs 현재 노드 시간 + 현재 노드 dp
                indegree[next]--;

                if(indegree[next]==0) q.add(next);
            }
        }
    }
}