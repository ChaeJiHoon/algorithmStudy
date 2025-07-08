import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = 0;
        int minSum = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++){
            int sum = bfs(i);
            if(sum<minSum){
                minSum = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];

        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : graph[now]){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }

        int sum = 0;
        for(int i=1;i<=N;i++) sum += dist[i];

        return sum;
    }
}
