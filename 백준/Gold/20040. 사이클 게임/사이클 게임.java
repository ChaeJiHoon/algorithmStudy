import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i=0;i<N;i++) parent[i] = i;

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!union(a, b)){
                System.out.println(i); // 사이클이 처음 발생한 턴
                return;
            }
        }
        System.out.println(0);
    }

    static int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return false;
        parent[b] = a;
        return true;
    }

}