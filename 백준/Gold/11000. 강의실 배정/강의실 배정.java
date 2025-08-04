import java.io.*;
import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture>{

        int start;
        int end;
        Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Lecture o){
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s,t);
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);

        for(int i=1;i<N;i++){
            if (lectures[i].start >= pq.peek()) pq.poll();
            pq.add(lectures[i].end);
        }
        
        System.out.println(pq.size());

    }
}
