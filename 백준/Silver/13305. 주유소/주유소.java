import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++) q.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        while(!q.isEmpty()) {
            int n = q.poll();
            pq.add(Integer.parseInt(st.nextToken()));

            int m = pq.poll();
            pq.add(m);
            sum += n*m;
        }

        System.out.println(sum);
    }
}