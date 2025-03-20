import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> highList = new ArrayList<Integer>();
        List<Integer> lowList = new ArrayList<Integer>();
        
        int n = 0;  // 발표 논문
        int h = 0;  // 인용 논문
        int h_index=0;
        for(int j=0;j<citations.length;j++){
            h++;  // 발표 수를 0-n 까지 배열 돌면서

            for(int i :citations){

                if(i>=h) highList.add(i);
                else lowList.add(i);
            }
            
            if(highList.size()>=h) h_index = h;
            highList.clear();
            lowList.clear();
            System.out.println(h_index);
        }
        
        
    return h_index;
    }
}