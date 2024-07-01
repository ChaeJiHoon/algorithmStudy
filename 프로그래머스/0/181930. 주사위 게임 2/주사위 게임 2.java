class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        int one = a+b+c;
        int two = (a*a)+(b*b)+(c*c);
        int three = (a*a*a)+(b*b*b)+(c*c*c);
        
        if(a==b && b==c){
            answer = one*two*three;
        }else if(a!=b && a!=c && b!=c){
            answer = one;
        }else answer = one*two;

        return answer;
    }
}