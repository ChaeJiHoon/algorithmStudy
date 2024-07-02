class Solution {
    public String solution(int[] numLog) {
        String answer = ""; 
        int a = 0;
        int b = 0; 
        for(int i=0;i<numLog.length-1;i++){
            a = numLog[i];
            b = numLog[i+1];
            if(a == b-1){
                answer += "w";
            }else if(a == b+1){
                answer += "s";
            }else if(a == b-10){
                answer += "d";
            }else if(a == b+10){
                answer += "a";
            }
        }
        return answer;
    }
}