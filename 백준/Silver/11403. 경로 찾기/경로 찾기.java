import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[][] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int N;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        answer = new int[N][N];

        for(int i=0;i<N;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num==1) graph[i].add(j);
            }
        }

        for(int i=0;i<N;i++) {
            visited = new boolean[N];
            path(i,i);
        }

        StringBuilder asb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) asb.append(answer[i][j]).append(" ");
            asb.append("\n");
        }

        System.out.println(asb.toString());
    }

    static void path(int start, int now){
        for(int next : graph[now]){
            if(!visited[next]){
                visited[next] = true;
                answer[start][next] = 1;
                path(start, next);
            }
        }
    }
}