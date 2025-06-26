import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            long num = Long.parseLong(br.readLine());

            if(num==0){
                if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append(0).append("\n");
            }else pq.add(num);
        }

        System.out.println(sb.toString());
    }
}
