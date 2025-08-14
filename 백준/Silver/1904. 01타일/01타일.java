import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];

        if(n==1) {
            System.out.print(1);
            return;
        }

        dp[1] = 1L;
        dp[2] = 2L;

        for(int i=3;i<=n;i++) dp[i] = (dp[i-1]+dp[i-2])%15746;

        System.out.print(dp[n]%15746L);
    }
}
