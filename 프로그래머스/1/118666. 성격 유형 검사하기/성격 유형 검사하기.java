import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<survey.length;i++){
            String[] s = survey[i].split(""); 
            
            int n = choices[i]-4;
            if(n<0) map.put(s[0],map.getOrDefault(s[0], 0)+Math.abs(n));
            else if(n>0)map.put(s[1],map.getOrDefault(s[1], 0)+n);
        }
        
        int r=0, t=0, c=0, f=0, j=0, m=0, a=0, n=0;
        
        if(map.get("R")!=null) r= map.get("R");
        if(map.get("T")!=null) t= map.get("T");
        if(r>=t) sb.append("R");
        else sb.append("T");    
        
        if(map.get("C")!=null) c= map.get("C");
        if(map.get("F")!=null) f= map.get("F");
        if(c>=f) sb.append("C");
        else sb.append("F");
        
        if(map.get("J")!=null) j= map.get("J");
        if(map.get("M")!=null) m= map.get("M");
        if(j>=m) sb.append("J");
        else sb.append("M");
        
        if(map.get("A")!=null) a= map.get("A");
        if(map.get("N")!=null) n= map.get("N");
        if(a>=n) sb.append("A");
        else sb.append("N");
        
        return sb.toString();
    }
}