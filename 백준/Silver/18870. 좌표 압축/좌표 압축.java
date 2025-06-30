import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
            map.put(num,0);
            pq.add(num);
        }

        int pre = pq.poll();
        int index = 0;
        map.put(pre,index);

        while(!pq.isEmpty()){
            int now = pq.poll();
            if(pre == now) pre = now;
            else{
                map.put(now,++index);
                pre = now;
            }
        }

        for(int i : arr) sb.append(map.get(i)).append(" ");

        System.out.println(sb.toString().trim());
    }
}
