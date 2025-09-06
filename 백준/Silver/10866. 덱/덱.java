import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num;
            switch(s){
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    dq.addLast(num);break;
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    dq.addFirst(num);break;
                case "front":
                    if(dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekFirst()).append("\n"); break;
                case "back":
                    if(dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekLast()).append("\n"); break;
                case "size":
                    sb.append(dq.size()).append("\n"); break;
                case "empty":
                    if(dq.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n"); break;
                case "pop_front":
                    if(dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.pollFirst()).append("\n"); break;
                case "pop_back":
                    if(dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.pollLast()).append("\n"); break;
            }
        }

        System.out.print(sb.toString().trim());
    }
}