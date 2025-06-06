package dp;

public class LongJump {
    public static void main(String[] args) {
        System.out.println(Solution.solution(5));
    }
}

class Solution {
    public static long[] dp = new long[2001];
    public static long solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-2]+dp[i-1])%1234567;
        }
        return dp[n];
    }
}
