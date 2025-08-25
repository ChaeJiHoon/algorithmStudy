import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        // 캐시 사이즈가 0이면
        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> cache = new LinkedList<>(); // 최근 사용 순서 기록
        int answer = 0;

        for(int i=0;i<cities.length;i++) {
            String city = cities[i].toLowerCase();

            if(cache.remove(city)){ 
                // 이미 캐시에 있는 경우: 삭제 후 맨 뒤(최신)로 이동
                cache.addLast(city);
                answer += 1;
            }else{
                // 캐시에 없는 경우
                if(cache.size()>=cacheSize){
                    cache.removeFirst(); // 가장 오래된 거 제거
                }
                
                cache.addLast(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}
