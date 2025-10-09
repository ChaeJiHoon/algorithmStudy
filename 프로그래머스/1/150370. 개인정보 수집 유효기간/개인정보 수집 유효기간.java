import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies){
        // 반환할 숫자를 담고 있는 리스트
        ArrayList<Integer> list = new ArrayList<>();
        
        // 약관 정보를 담고 있는 맵
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : terms){
            String[] sArr = s.split(" ");
            map.put(sArr[0], Integer.parseInt(sArr[1]));
        }
        
        // 오늘 기간을 변환
        int todayNum = converse(today);
        int index = 0;
        for(String s : privacies){
            index++;
            String[] sArr = s.split(" ");
            int day = converse(sArr[0]) + map.get(sArr[1])*28;
            if(todayNum>=day) list.add(index);
        }
        
        return list
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    
    static int converse(String str){
        String[] td = str.replace(".", " ").split(" ");
        
        int tdYear = Integer.parseInt(td[0])*336;
        int tdDay = Integer.parseInt(td[1])*28+Integer.parseInt(td[2]);
        
        return tdYear+tdDay;
    }
}