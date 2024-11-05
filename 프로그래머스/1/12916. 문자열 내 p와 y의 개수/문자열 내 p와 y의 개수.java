class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String[] strArr = s.split("");
        int a=0,b=0;
        
        for(int i=0;i<strArr.length;i++){
            if(strArr[i].equalsIgnoreCase("p")) a++;
            if(strArr[i].equalsIgnoreCase("y")) b++;
        }
        if(a==b) answer = true;
        else answer = false;

        return answer;
    }
}