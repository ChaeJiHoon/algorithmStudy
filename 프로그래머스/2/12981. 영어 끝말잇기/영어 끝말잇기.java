import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String s : words) q.add(s);
        
        
        int[] answer = {0,0};
        int index = 1;
        int num = 1;
        String pre = q.poll();
        String now = "";
    
        set.add(pre);
        while(!q.isEmpty()){
            now = q.poll();
            
            if(index==n) {
                index=1;
                num++;
            }
            else index++;
            
            if(pre.charAt(pre.length()-1)!=now.charAt(0)){
                answer = new int[]{index,num};
                break;
            }
            
            if(set.contains(now)){
                answer = new int[]{index,num};
                break;
            }
            
            
            
            pre = now;
            set.add(pre);
        }
        

        return answer;
    }
}