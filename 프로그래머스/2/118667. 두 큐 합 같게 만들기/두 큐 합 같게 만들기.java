import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        for(int i : queue1) {
            q1.add(i);
            sum1 += i;
        }
        for(int i : queue2) {
            q2.add(i);
            sum2 += i;
        }
        
        int time = -1;
        int len = q1.size()*2;
        
        while(time++<=len+1){
            if(sum1==sum2) return time;
            else if(sum1>sum2){
                int n = q1.poll();
                q2.add(n);
                sum1 -= n;
                sum2 += n;
            }else{
                int n = q2.poll();
                q1.add(n);
                sum2 -= n;
                sum1 += n;
            }
        }
        
    
        return -1;
    }
}