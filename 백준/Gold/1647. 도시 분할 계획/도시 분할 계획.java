import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{

        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {return this.weight - e.weight;}
    }

    static List<Edge> city;
    static int[] parent;
    static int N;
    static int M;
    static int answer = 0;
    static int max_weight = 0;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new ArrayList<>();
        parent = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            city.add(new Edge(A,B,C));
        }

        Collections.sort(city);

        for(int i=0;i<=N;i++) parent[i] = i;

        int answer = 0;
        int max = 0;

        for(Edge edge : city){
            if(find(edge.from) != find(edge.to)){
                union(edge.from, edge.to);
                answer += edge.weight;
                max = Math.max(max, edge.weight);
            }
        }

        System.out.println(answer - max);
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }
}
