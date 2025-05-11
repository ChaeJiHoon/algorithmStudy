import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] str : clothes) {

            map.put(str[1], map.getOrDefault(str[1], 0) + 1);
        }

        for (String str : map.keySet()) {
            answer *= (map.get(str) + 1);
        }

        answer--;
        
        return answer;
    }
}