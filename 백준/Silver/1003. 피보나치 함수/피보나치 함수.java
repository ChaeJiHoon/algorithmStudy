import java.util.*;

public class Main {
    static int[][] dp = new int[41][2];  // 최대 40까지 가능

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 초기값 세팅
        dp[0][0] = 1;  // fibonacci(0) → 0 출력 1회
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;  // fibonacci(1) → 1 출력 1회

        // DP 테이블 채우기
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        // 테스트케이스 출력
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
