import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시 수
        M = Integer.parseInt(br.readLine()); // 버스 수

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int current = now.to;

            if (dist[current] < now.cost) continue;

            for (Node next : graph[current]) {
                int newCost = dist[current] + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }
}
