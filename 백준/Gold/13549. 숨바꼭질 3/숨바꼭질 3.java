import java.io.*;
import java.util.*;

public class Main {

    static int[] dist = new int[100001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        bfs(N);

        System.out.println(dist[K]);
    }

    static void bfs(int N){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{N,0});
        dist[N] = 0;

        while(!dq.isEmpty()){

            int[] curr = dq.poll();
            int pos = curr[0];
            int time = curr[1];

            if(pos*2<=100000 && time < dist[pos*2]){
                dist[pos*2] = time;
                dq.addFirst(new int[]{pos*2, time});
            }
            if(pos+1<=100000 && time < dist[pos+1]){
                dist[pos+1] = time+1;
                dq.addLast(new int[]{pos+1, time+1});
            }
            if(0<=pos-1 && time < dist[pos-1]){
                dist[pos-1] = time+1;
                dq.addLast(new int[]{pos-1, time+1});
            }

        }
    }
}
