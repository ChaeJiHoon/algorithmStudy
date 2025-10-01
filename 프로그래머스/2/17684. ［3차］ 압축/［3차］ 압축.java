import java.util.*;

class Solution {
    
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<26;i++) map.put(Character.toString('A'+i),i+1);
        int index = 27;
        
        
        // 글자를 가리키는 인데스
        int at = 0;
        
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while(at<msg.length()){
            
            sb.append(msg.charAt(at));
            String str = sb.toString();

            // 현재 sb가 map에 있으면 index, at만 변경
            if(map.containsKey(str)){
                at++; // 0 -> 1
                num = map.get(str); // 11
                
            }else{
                // 현재 단어, 인덱스를 map에 등록
                map.put(str,index++);  // map : (KA, 27)
                sb.setLength(0);
                q.add(num);
                
            }
        }
        q.add(num);
        
        int len = q.size();
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++) answer[i] = q.poll();
        
        return answer;
        
            
    }
}