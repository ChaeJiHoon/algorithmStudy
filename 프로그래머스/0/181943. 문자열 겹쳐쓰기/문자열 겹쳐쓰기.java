class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int n1 = my_string.length();
        int n2 = overwrite_string.length();
        
        answer = my_string.substring(0,s);
        answer += overwrite_string;
        answer += my_string.substring(s+n2,n1);
        
        return answer;
    }
}