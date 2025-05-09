package queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnBridge {
    public static void main(String[] args) {
        int[] arr = {7,4,5,6};

        System.out.println(solution(2, 10, arr));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weigth){
        int answer = 0, b_w=0;  // b_w : 현재 다리 위 무게
        Queue<Integer> q1 = new LinkedList<>();  // 트럭 대기 큐
        Queue<Integer> q2 = new LinkedList<>();  // 다리위 트럭 큐
        Queue<Integer> q3 = new LinkedList<>();  // 시간 기록 큐

        for(int truck:truck_weigth){            // 문제 없음
            q1.add(truck);
        }

        q2.add(q1.poll());  // 다리 위에 첫번째 트럭 적재
        answer++;           // 1초지남
        b_w += q2.peek();   // 무게 용량 증가

        q3.add(answer+bridge_length);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            answer++;

            // 트럭이 다리를 다 건넌 경우 (시간 도달)
            if (!q3.isEmpty() && q3.peek() == answer) {
                q3.poll();          // 시간 삭제
                b_w -= q2.poll();   // 다리 위 무게에서 트럭 무게 빼기
            }

            // 새로운 트럭을 다리에 올릴 수 있다면
            if (!q1.isEmpty() && (b_w + q1.peek()) <= weight) {  // 대기 트럭이 없지 않고 && 최대 무게보다 더 작은 경우
                int nextTruck = q1.poll();  // 다음 트럭 변수 설정
                q2.add(nextTruck);          // 다리 위로 트럭 올림
                b_w += nextTruck;           // 현재 다리 위 무게 갱신
                q3.add(answer + bridge_length);  // 트럭이 다리를 다 건너는 시간 기록
            }
        }


        /*
        while(!q2.isEmpty() || !q1.isEmpty()){   // 다리위 트럭과 대기 트럭이 하나도 없을때까지 반복문 진행
            System.out.println(answer);


            if(weight>(b_w+q2.peek())) {    // 다리 위 트럭과 다음 대기 트럭 무게 합이 최대 용량보다 작은 경 우
                q2.add(q1.poll()); // 트럭 대기 큐에서 빼서 다리위 트럭으로 삽입
                b_w +=  q2.peek(); // 현재 다리 위 무게 증가
                q3.add(answer+bridge_length); // 시간 기록 큐에는 나가는 시간 기록
            }



            if(q3.peek()== answer){ // 트럭이 다리위를 다 지나면
                q3.poll();          // 나가는 시간 삭제
                q2.poll();          // 다리 위 트럭 삭제
                q2.add(q1.poll());  // 대기 큐 트럭 하나 빼고, 다리 위 큐 하나 증가
                q3.add(answer+bridge_length); // 시간 기록 큐에는 나가는 시간 기록
            }
            answer++;
        }
        */

        return answer;
    }
}
