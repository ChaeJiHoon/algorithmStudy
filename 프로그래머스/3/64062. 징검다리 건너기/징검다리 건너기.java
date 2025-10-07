import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int answer = Integer.MAX_VALUE;

        for (int i=0;i<stones.length; i++) {

            while(!dq.isEmpty() && stones[dq.peekLast()] <= stones[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            
            int left = i-k+1; 
            if(left>=0){
                while (!dq.isEmpty() && dq.peekFirst() < left) {
                    dq.pollFirst();
                }
                int windowMax = stones[dq.peekFirst()];
                answer = Math.min(answer, windowMax);
            }
        }
        return answer;
    }
}
