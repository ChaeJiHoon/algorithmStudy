import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 여기에 초단위로 숫자를 넣어서 저장
        
        for(int i=0;i<timetable.length;i++){
            String[] str = timetable[i].split(":");
    
            int hour = Integer.parseInt(str[0])*60;
            int minute = Integer.parseInt(str[1]);
            
            pq.add((hour+minute));
        }
        
        int[] crew = new int[pq.size()];
        for(int i=0;i<crew.length;i++) crew[i] = pq.poll();
        
        int bus = 9*60; 
        int idx = 0;      // crew 인덱스
        int lastBoarded = -1; // 마지막 버스에서 마지막으로 탄 사람 시간 추적용
        int k = crew.length;
        
        for(int i=0;i<n;i++){
            int boarded = 0;
            
            while (boarded<m && idx<k && crew[idx]<=bus) {
                lastBoarded = crew[idx];
                idx++;
                boarded++;
            }

            //마지막 버스 판단
            if (i==n-1){
                int ans;
                 
                if (boarded < m) ans = bus; // 자리가 남음 → 버스 시각에 맞춤
                else ans = lastBoarded - 1; // 꽉 참 → 마지막으로 탄 사람보다 1분 빨리
                
                if (ans<0) ans = 0;
                
                String HH = Integer.toString(ans/60);
                String MM = Integer.toString(ans%60);
                
                if(HH.length()==1) HH = "0"+HH;
                if(MM.length()==1) MM = "0"+MM;
                
                return HH+":"+MM;
            }

            bus += t;
        }

        return "";
    }
}