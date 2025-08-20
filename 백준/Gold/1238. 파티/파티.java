import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int to;
        int weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    static int N,M,X;
    static List<Node>[] graph;
    static int[][] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());       // 파티 장소

        graph = new ArrayList[N+1];
        dist = new int[N+1][N+1];
        for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to,weight));
        }

        for(int i=1;i<=N;i++) dijkstra(i);

        int max = 0;
        for(int i=1;i<=N;i++) if(i!=X) max = Math.max(max, dist[i][X]+dist[X][i]);


        System.out.println(max);
    }


    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(dist[start],Integer.MAX_VALUE);
        dist[start][start] = 0;

        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int current = now.to;   // 다음 갈 노드

            if(dist[start][current] < now.weight) continue;

            for(Node next : graph[current]){
                int newWeight = dist[start][current] + next.weight;

                if(newWeight<dist[start][next.to]){
                    dist[start][next.to] = newWeight;
                    pq.add(new Node(next.to, newWeight));
                }
            }
        }
    }
}