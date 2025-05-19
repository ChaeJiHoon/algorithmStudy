import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            if(str[0].contains("push")) {
                dq.offer(Integer.parseInt(str[1]));
            }else if(str[0].contains("pop")) {
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.pollFirst());
            }else if(str[0].contains("size")) {
                System.out.println(dq.size());
            }else if(str[0].contains("empty")){
                if(dq.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }else if(str[0].contains("front")){
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.peekFirst());
            }else if(str[0].contains("back")){
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.peekLast());
            }
        }
    }
}
