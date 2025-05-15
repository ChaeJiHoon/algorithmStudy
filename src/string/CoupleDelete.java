package string;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class CoupleDelete {
    public static void main(String[] args) {
        CoupleDelete cp = new CoupleDelete();
        System.out.println(cp.solution("abbcddeeca"));
    }


    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // 짝이면 제거
            } else {
                stack.push(ch); // 아니면 추가
            }
        }
            return stack.isEmpty() ? 1 : 0;
    }

}
