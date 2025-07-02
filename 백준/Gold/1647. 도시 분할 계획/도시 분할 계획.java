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
        public int compareTo(Node n) {return this.weight - n.weight;}
    }

    static List<Node>[] city;
    static boolean[] visited;
    static int N;
    static int M;
    static int answer = 0;
    static int max_weight = 0;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new ArrayList[N+1];
        for(int i=0;i<=N;i++) city[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            city[A].add(new Node(B,C));
            city[B].add(new Node(A,C));
        }

        prim(1);

        System.out.println(answer - max_weight);
    }

    static void prim(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N+1];
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if(visited[current.to]) continue;

            visited[current.to] = true;
            answer += current.weight;
            max_weight = Math.max(current.weight,max_weight);

            for(Node node : city[current.to]){
                if(!visited[node.to]) {
                    pq.offer(node);
                }
            }
        }

    }
}