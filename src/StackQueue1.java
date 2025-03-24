/*
* 프로그래머스 알고리즘 kit
* 스택 / 큐
* 같은 숫자는 싫어
* */


import java.util.*;

public class StackQueue1 {
    public static void main(String[] args) {
        StackQueue1 SQ = new StackQueue1();

        int[] arr = {1,1,3,3,0,1,1};

        for(int ar : SQ.solution1(arr)){
            System.out.println(ar);
        }
    }

    /*
    첫번째 해결 방법 :
    */

    public int[] solution1(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        int previous = -1;

        for (int i : arr) {
            if (i != previous) {
                q.offer(i);
            }
            previous = i;
        }
        int[] answer = new int[q.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] += q.poll();
        }
        return answer;
    }

    public int[] solution2(int[] arr){
        int[] answer = new int[4];


        return answer;
    }
}
