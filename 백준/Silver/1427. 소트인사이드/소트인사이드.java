import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        String[] num = br.readLine().split("");

        for(int i=0;i<num.length;i++) pq.add(Integer.parseInt(num[i]));

        while(!pq.isEmpty()) sb.append(pq.poll());
        System.out.println(sb.toString());
    }
}