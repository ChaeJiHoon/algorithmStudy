import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] tree;
    static int leafNode = 0;
    static int delete;
    static int root;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for(int i=0;i<N;i++) tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1) tree[parent].add(i);
            else root = i;
        }

        delete = Integer.parseInt(br.readLine());

        if(delete == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(leafNode);
    }

    static void dfs(int node){
        if (node == delete) return;

        if (tree[node].isEmpty()) {
            leafNode++;
            return;
        }

        boolean hasChild = false;
        for(int child : tree[node]){
            if (child == delete) continue;
            hasChild = true;
            dfs(child);
        }

        if (!hasChild) leafNode++;
    }
}
