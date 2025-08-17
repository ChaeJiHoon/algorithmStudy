import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) pq.add(Integer.parseInt(br.readLine()));

        while(!pq.isEmpty()) System.out.println(pq.poll());
    }
}