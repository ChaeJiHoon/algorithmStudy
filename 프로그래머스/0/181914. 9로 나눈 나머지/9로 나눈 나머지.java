class Solution {
    public int solution(String number) {
        int answer = 0;
        int n = 0;
        String[] str = number.split("");
        
        for(int i=0;i<number.length();i++){
            n += Integer.parseInt(str[i]);
        }
        answer = n%9;
        
        return answer;
    }
}