import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 입력 숫자

        int[] dp = new int[n + 1];
        dp[1] = 0;  // 1은 0번 연산

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;  // 기본적으로 -1 했을 때

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
