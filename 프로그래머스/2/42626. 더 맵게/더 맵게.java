import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();  
        for(int sc : scoville){
            pQ.offer(sc);
        }
        
        int min = pQ.peek();
        
        while(min<K){
            if(pQ.size()>=2){
                pQ.offer(pQ.poll()+pQ.poll()*2);
                min = pQ.peek();
                answer++;
            }
            else return -1;
        }

        return answer;
    }
}