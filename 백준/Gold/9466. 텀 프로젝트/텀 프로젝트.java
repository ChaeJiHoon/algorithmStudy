import java.io.*;
import java.util.*;

public class Main {

    static int[] people;
    static boolean[] visited;
    static boolean[] finished;
    static int count; // 사이클에 포함된 사람 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            people = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++) people[i] = Integer.parseInt(st.nextToken());
            for(int i=1;i<=n;i++) if(!visited[i]) dfs(i);

            sb.append(n-count).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int curr) {
        visited[curr] = true;
        int next = people[curr];

        if(!visited[next]) dfs(next);
        else if(!finished[next]){  // 사이클 발견
            for(int i=next;i!=curr;i=people[i]) count++;
            count++; // 자기 자신도 포함
        }

        finished[curr] = true;
    }
}
