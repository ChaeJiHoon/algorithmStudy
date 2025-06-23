import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int to;
        int weight;
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] list;
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];

        for(int i=0;i<=V;i++) list[i] = new ArrayList<>();

        for(int i=1;i<=V;i++){
            String[] str = br.readLine().split(" ");
            int parent = Integer.parseInt(str[0]);
            int to,weight;

            for(int j=1;j<str.length-1;j+=2){
                to = Integer.parseInt(str[j]);
                weight = Integer.parseInt(str[j+1]);
                list[parent].add(new Node(to, weight));
                list[to].add(new Node(parent, weight));
            }
        }

        visited = new boolean[V+1];
        dfs(1,0);

        visited = new boolean[V+1];
        maxDist = 0;
        dfs(farNode,0);

        System.out.println(maxDist);

    }

    static void dfs(int node, int dist){
        visited[node] = true;

        if(maxDist<dist){
            maxDist = dist;
            farNode = node;
        }
        for(Node n: list[node]){
            if(!visited[n.to]) dfs(n.to, dist + n.weight);
        }

    }

}