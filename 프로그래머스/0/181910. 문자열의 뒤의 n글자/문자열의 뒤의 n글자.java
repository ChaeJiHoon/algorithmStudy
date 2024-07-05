class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String[] str = my_string.split("");
        for(int i=my_string.length()-n;i<my_string.length();i++){
            answer += str[i];
        }
        return answer;
    }
}