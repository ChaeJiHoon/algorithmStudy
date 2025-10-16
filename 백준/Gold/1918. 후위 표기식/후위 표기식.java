import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        StringBuilder sb = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>(); // 연산자/괄호 스택

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(isOperand(c)) sb.append(c);
            else if(c == '(') st.push(c);
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '(') sb.append(st.pop());
                st.pop();
            }else{
                while(!st.isEmpty() && st.peek()!='(' && prec(st.peek()) >= prec(c)) sb.append(st.pop());
                st.push(c);
            }
        }
        while(!st.isEmpty()) sb.append(st.pop());

        System.out.println(sb.toString());
    }

    private static boolean isOperand(char c) {return 'A'<=c && c<='Z';}

    private static int prec(char op) {
        if(op=='*' || op=='/') return 2;
        if(op=='+' || op=='-') return 1;
        return 0;
    }
}
