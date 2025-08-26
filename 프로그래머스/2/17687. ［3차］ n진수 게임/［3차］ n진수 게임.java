import java.util.*;

// t가 10인 경우는 int로 받고 나머지는 toString()처리 진행

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        
        int index = 0;
        
        
        while(list.size()<=1000_000){
            // 진법 변환
            String[] num = Integer.toString(index,n).toUpperCase().split("");
            
            // 리스트에 순서대로 넣기
            for(int i=0;i<num.length;i++) {
                
                list.add(num[i]);
            }
            // 인덱스 증가
            index++;
        }
        
        int nIndex = p-1;
        while(t-->0){
            sb.append(list.get(nIndex));
            nIndex += m;
        }
        
        
        String answer = sb.toString();
        return answer;
    }
}