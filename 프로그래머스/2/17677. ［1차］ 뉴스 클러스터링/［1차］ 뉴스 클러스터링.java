import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 다중집합(Map<문자쌍, 개수>)
        Map<String, Integer> map1 = makeMultiset(str1);
        Map<String, Integer> map2 = makeMultiset(str2);
        
        // 교집합, 합집합
        int inter = 0;
        int union = 0;
        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        for (String key : keys) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);
            
            inter += Math.min(c1, c2); // 교집합
            union += Math.max(c1, c2); // 합집합
        }
        
        // 둘 다 공집합이면 유사도=1
        if (union == 0) return 65536;
        
        // 자카드 유사도 × 65536
        return (int) ((double) inter / union * 65536);
    }
    
    // 문자열 → 다중집합(2글자 단어 -> 개수 Map)
    private Map<String, Integer> makeMultiset(String s){
        Map<String, Integer> map = new HashMap<>();
        
        for (int i=0;i<s.length()-1;i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            
            // 알파벳 쌍일 때만 유효
            if(Character.isLetter(a) && Character.isLetter(b)){
                String sub = "" + a + b;
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        return map;
    }
}
