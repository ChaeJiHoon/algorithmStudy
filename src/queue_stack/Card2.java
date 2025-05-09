package queue_stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        cardGame(sc.nextInt());

    }

    public static int cardGame(int num){
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=num;i++){
            q.offer(i);
        }

        while(q.size()!=1){
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.peek());

        return answer;
    }


}
