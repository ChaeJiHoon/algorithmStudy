package queue_stack;

import java.util.Stack;

public class testClass {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.push(2);

        System.out.println(stack.add(1));
        System.out.println(stack.push(2));
    }
}
