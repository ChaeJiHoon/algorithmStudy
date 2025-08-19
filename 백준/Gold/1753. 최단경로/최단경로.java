import java.util.*;
import java.io.*;

public class Main {
    static List<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // V : 노드, E : 간선
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        dist = new int[V+1];

        int startNode = Integer.parseInt(br.readLine());

        for(int i=0;i<=V;i++) {
            graph[i] = new ArrayList<>();
            if(i!=startNode) dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to,weight));
        }

        dijkstra(startNode);

        for(int i=1;i<=V;i++){
            if(dist[i]==Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dijkstra(int start){
        // 간선 가중치 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int current = now.to;

            if(dist[current]<now.weight) continue;

            for(Node next : graph[current]){
                // 현재까지 노드 누적 가중치 + 다음 노드 가중치
                int newCost = dist[current] + next.weight;

                // newCost가 더 작은 경우 갱신
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }



    static class Node implements Comparable<Node>{

        int to;
        int weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}