package greedy;
// 프로그래머스 | 그리디 | Lv.2
// 탐욕법(Greedy) : 구명 보트
// 통과 성공
// 25.05.21
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LifeBoat2 {
    public static void main(String[] args) {
        Solution1 so = new Solution1();
        int[] arr = {70,50,80,50};
        System.out.println(so.solution(arr,100));
    }
}

class Solution1{

    public int solution(int[] people, int limit){
        int answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        Arrays.sort(people);

        for (int ar : people) {
            dq.add(ar);
        }

        while(!dq.isEmpty()){
            int a = dq.pollLast();      // 가장 큰 수 뺌
            if(dq.isEmpty()){
                answer++;
                break;
            }
            int b = dq.peekFirst();     // 가장 작은 수 뺌
            if(a+b<=limit){
                dq.pollFirst();
            }
            answer++;
        }

        return answer;
    }



}