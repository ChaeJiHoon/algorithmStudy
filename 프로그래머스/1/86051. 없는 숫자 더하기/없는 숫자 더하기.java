import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        int answer = 0;
        for(int i : numbers) set.add(i);
        for(int i=1;i<=9;i++) if(!set.contains(i)) answer += i;
        
        return answer;
    }
}