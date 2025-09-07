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

            String str = st.nextToken();

            if(str.equals("push")){
                dq.add(Integer.parseInt(st.nextToken()));
            }else if(str.equals("pop")){
                if(dq.isEmpty())sb.append(-1).append("\n");
                else sb.append(dq.poll()).append("\n");
            }else if(str.equals("size")){
                sb.append(dq.size()).append("\n");
            }else if(str.equals("empty")){
                if(dq.isEmpty())sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(str.equals("front")){
                if(dq.isEmpty())sb.append(-1).append("\n");
                else sb.append(dq.peek()).append("\n");
            }else if(str.equals("back")){
                if(dq.isEmpty())sb.append(-1).append("\n");
                else sb.append(dq.peekLast()).append("\n");
            }

        }
        System.out.println(sb.toString());


    }

}