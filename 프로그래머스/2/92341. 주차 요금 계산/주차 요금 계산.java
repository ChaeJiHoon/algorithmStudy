import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> useMap = new HashMap<>();  // 사용시간
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
    
        // : 처리
        for(String s : records){
            String[] str = s.replaceAll(":", " ").split(" ");
            String[] hour = str[0].split("");
            
            int time = 
                Integer.parseInt(hour[0])*600 + 
                Integer.parseInt(hour[1])*60 + 
                Integer.parseInt(str[1]);
            
            // IN 인경우 저장
            if(str[3].equals("IN")) inMap.put(str[2], time);
            else { // out 인 경우 시간 누적과 동시에 inMap에서삭제
                int useTime = time - inMap.get(str[2]);
                
                useMap.put(str[2],useMap.getOrDefault(str[2],0)+useTime);
                inMap.remove(str[2]);
            }
        } 
        
        // 아직 안빠진 녀석들 삭제
        int l = inMap.size();
        ArrayList<String> in = new ArrayList<>(inMap.keySet());
        
        for(int i=0;i<l;i++) {
            String s = in.get(i);
            int useTime = 1439 - inMap.get(s);
            
            useMap.put(s,useMap.getOrDefault(s,0)+useTime);
        }

        // 차 번호 키 리스트
        ArrayList<String> car = new ArrayList<>(useMap.keySet());
        Collections.sort(car);
        
        int index = 0;
        int[] answer = new int[car.size()];
        
        for(String s : car) {
            int p = basicFee;
            int useTime = useMap.get(s);
            if(useTime>basicTime){
                p += ((useTime-basicTime)/unitTime)*unitFee;  
                if((useTime-basicTime)%unitTime>0) p += unitFee;
            } 
            answer[index++] = p;
        }

        return answer;
    }
}