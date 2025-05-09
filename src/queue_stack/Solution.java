package queue_stack;

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(!pq.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(priorities[i] == pq.peek()){  // priorties[i]가 가장 우선순위가 높은 경우
                    pq.poll(); // 우선순위 큐 맨앞(가장 큰 수 삭제)
                    answer++;  // answer++ 값 증가 시키면서 순서 기록

                    if(i == location){  // priorties[i]가 가장 우선순위가 높으면서, 내가 찾던 location 인 경우이다.
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
