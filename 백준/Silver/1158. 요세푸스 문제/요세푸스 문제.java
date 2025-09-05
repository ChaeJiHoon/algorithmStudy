import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++) q.add(i);

        sb.append("<");

        int index = 0;

        while(!q.isEmpty()){
            if(q.size()==1) {
                sb.append(q.poll());
                break;
            }
            index++;
            if(index==K){
                sb.append(q.poll()).append(", ");
                index = 0;
            }else q.add(q.poll());
        }

        sb.append(">");

        System.out.print(sb.toString());
    }
}
