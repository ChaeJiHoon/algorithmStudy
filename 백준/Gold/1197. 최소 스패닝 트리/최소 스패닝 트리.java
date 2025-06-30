import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int from, to, weight;

        Node(int to, int from, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 가중치 정렬 설정
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 개수
        int V = Integer.parseInt(st.nextToken());
        // 간선 개수
        int E = Integer.parseInt(st.nextToken());

        List<Node> nodeList = new ArrayList<>();

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            nodeList.add(new Node(A, B, C));
        }

        // 가중치 정렬
        Collections.sort(nodeList);

        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) parent[i] = i;

        int answer = 0;

        for(Node node : nodeList){
            if(find(node.from) != find(node.to)){
                union(node.from, node.to);
                answer += node.weight;
            }
        }

        System.out.println(answer);
    }


    static int find(int x) {
        // 자기자신이 루트면 반환하고 종료
        if (parent[x] == x) return x;
        // 경로 압축
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        // 하나를 다른곳에 붙임
        if(a != b) parent[b] = a;
    }

}