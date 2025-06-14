import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            // 수행할 함수
            String[] P = br.readLine().split("");

            // 배열 길이
            int n = Integer.parseInt(br.readLine());

            // 숫자 저장 토큰
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");

            // 트리거
            // true : 앞에서 시작
            // false : 뒤에서 시작
            boolean trigger = true;

            // 숫자 저장 큐
            Deque<Integer> dq = new LinkedList<>();
            for(int i=0;i<n;i++) dq.add(Integer.parseInt(st.nextToken()));


            int x = 0;
            // 문자 처리
            for(int i=0;i<P.length;i++){
                // S인경우 트리거 바꿈
                if(P[i].equals("R")) trigger = !trigger;
                // D인경우 트리거에 따라 앞에서 지우거나 뒤에서 지움
                else{
                    if(trigger){
                        if(dq.isEmpty()) {
                            sb.append("error").append("\n");
                            x++;
                            break;
                        }
                        dq.pollFirst();
                    }else{
                        if(dq.isEmpty()) {
                            sb.append("error").append("\n");
                            x++;
                            break;
                        }
                        dq.pollLast();
                    }
                }
            }
            if(x==1) continue;

            sb.append("[");
            int size = dq.size();
            if(trigger){
                for(int i=0;i<size;i++) {
                    if(i!=size-1)sb.append(dq.pollFirst()).append(",");
                    else sb.append(dq.pollFirst());
                }
            }else {
                for(int i=size-1;i>=0;i--) {
                    if(i!=0)sb.append(dq.pollLast()).append(",");
                    else sb.append(dq.pollLast());
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }



}
