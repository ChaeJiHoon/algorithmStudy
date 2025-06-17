import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());

    }
    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = true;

        // [0] 숫자, [1] 실행횟수
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int num = now[0];
            int cnt = now[1];

            if(num == K) return cnt;

            int[] nextPosition = {num-1, num+1, num*2};

            for(int next : nextPosition){
                if(next >=0 && next<=100000 && !visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next, cnt+1});
                }
            }
        }

        return -1;
    }
}
