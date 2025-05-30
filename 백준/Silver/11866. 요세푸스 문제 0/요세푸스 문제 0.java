import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i=1;i<=n;i++){
            q1.add(i);
        }

        while(!q1.isEmpty()){
            cnt++;
            if(cnt==k){
                q2.add(q1.poll());
                cnt = 0;
            }else q1.add(q1.poll());
        }

        sb.append("<");
        for(int i=0;i<n;i++) {
            if (i == n - 1) sb.append(q2.poll()).append(">");
            else sb.append(q2.poll()).append(", ");
        }
        System.out.println(sb.toString());
    }
}