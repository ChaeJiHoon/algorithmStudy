package queue_stack;
// 백준 | 스택 | 실버2
// 1874 번 : 스택 수열
// 시간 제한 : 2초, 메모리 제한 : 128 MB
// 25.06.06

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class StackSequence {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int pre = 0;

        int n = Integer.parseInt(br.readLine());
        boolean trigger = true;

        for(int i=0;i<n;i++){
            int target = Integer.parseInt(br.readLine());
            if(target<pre){
                if(stack.peek()==target){
                    stack.pop();
                    sb.append("-").append("\n");
                }else{
                    System.out.println("NO");
                    trigger = false;
                    break;
                }

            }else{
                for(int j=pre+1;j<=target;j++){
                    stack.add(j);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
                pre = target;
            }
        }

        if(trigger)System.out.println(sb);

    }
}
