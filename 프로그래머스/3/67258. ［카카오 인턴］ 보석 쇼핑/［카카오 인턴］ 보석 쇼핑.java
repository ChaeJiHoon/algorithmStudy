import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        
        for(String s : gems) set.add(s);
        
        int type = set.size();
        if(type==1) return new int[]{1,1};
        
        int left = 0;
        int right = 1;
        int min = Integer.MAX_VALUE;
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put(gems[left],1);
        
        while(right<gems.length){  
            if(map.size()<type) map.put(gems[right], map.getOrDefault(gems[right++],0)+1);
            if(map.size()==type){
                if(min>(right-left)){
                    //System.out.println("실행되나?");
                    //System.out.println("left 값: " + gems[left] + ",  left 좌표: " + left);
                    //System.out.println("right 값: " + gems[right]+ ",  right 좌표: " + right);
                    //System.out.println();
                    min = right-left;
                    answer = new int[]{left+1,right};
                }
                if(map.get(gems[left])==1) map.remove(gems[left]);
                else map.put(gems[left], map.get(gems[left])-1);
                left++;
            }
        }
        
        while(right==gems.length && map.size()==type){
            if(min>(right-left)){
                    min = right-left;
                    answer = new int[]{left+1,right};
                }
                if(map.get(gems[left])==1) map.remove(gems[left]);
                else map.put(gems[left], map.get(gems[left])-1);
                left++;
        }
        
        
        
        return answer;
    }
}