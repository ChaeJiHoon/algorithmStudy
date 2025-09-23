import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<String> list = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            return a.length() - b.length();
        });
        
        int index = 1;
        int start = 1;
    
        while(index<s.length()-1){
            StringBuilder sb = new StringBuilder();
            if(s.charAt(start)=='{'){
                index = start+1;
                //sb.append(s.charAt(index));
                while(s.charAt(index)!='}'){
                    sb.append(s.charAt(index++));       
                }
                // 이제 index == '}'인 상태임
                pq.add(sb.toString());
                start = index++;
            }
            start++;
            
        }
        
        while(!pq.isEmpty()){
            String[] strArr = pq.poll().split(",");
            
            for(String str : strArr){
                if(!list.contains(str)) {
                    list.add(str);
                    break;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}