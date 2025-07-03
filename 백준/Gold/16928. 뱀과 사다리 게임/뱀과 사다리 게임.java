import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static HashMap<Integer, Integer> ladders = new HashMap<>();
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladders.put(from, to); // 수정: from → to
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0}); // {현재 칸, 주사위 횟수}
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if (pos == 100) return cnt;

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100 || visited[next]) continue;

                if (ladders.containsKey(next)) {
                    next = ladders.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }
}
