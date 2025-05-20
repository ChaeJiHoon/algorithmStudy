package queue_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack1 {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         Stack<Integer> stack = new Stack<>();

         for(int i=0;i<n;i++){
             String[] str = br.readLine().split(" ");
             if(str[0].contains("push")) {
                 stack.push(Integer.parseInt(str[1]));
             }else if(str[0].contains("pop")) {
                 if(stack.empty()) System.out.println(-1);
                 else System.out.println(stack.pop());
             }else if(str[0].contains("size")) {
                 System.out.println(stack.size());
             }else if(str[0].contains("empty")){
                 if(stack.empty()) System.out.println(1);
                 else System.out.println(0);
             }else if(str[0].contains("top")){
                if(stack.empty()) System.out.println(-1);
                else System.out.println(stack.peek());
             }
         }
    }

}
