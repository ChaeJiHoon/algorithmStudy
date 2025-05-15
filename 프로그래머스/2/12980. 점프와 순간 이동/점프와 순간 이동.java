import java.util.*;

public class Solution {
    public int solution(int n){
        int num = n;
        int count = 1 ;
        while(num !=1)
            if(num%2 == 1) {        // 홀수인경우
                num  /= 2;
                count++;
            }else num /= 2;          // 짝수인경우

        return count;
    }
}