import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<intStrs.length;i++){
            String str = intStrs[i].substring(s, s+l);
            int num = Integer.parseInt(str);
            if(num>k) arr.add(num);
        }
        
        int[] answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}