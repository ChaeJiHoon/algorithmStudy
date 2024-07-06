class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        String[] str = new String[m];
        for(int i=0;i<my_string.length()/m;i++){
            str = my_string.substring(i*m,(i+1)*m).split("");
            answer += str[c-1];
        }
        return answer;
    }
}