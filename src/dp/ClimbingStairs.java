package dp;
// 백준 | 다이나믹 프로그래밍 | 실버3
// 2579 번 : 계단 오르기
// 시간 제한 : 1초, 메모리 제한 : 128 MB
// 25.05.27, Bottom-Up 방식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];

        if(n>=2) dp[2] = arr[2];

        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1]) + arr[i];
        }

        System.out.println(dp[n]);

    }
}
