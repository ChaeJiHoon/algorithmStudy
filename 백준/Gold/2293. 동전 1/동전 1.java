import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i=0;i<n;i++) coins[i] = Integer.parseInt(br.readLine());

        long[] dp = new long[k+1];
        dp[0] = 1;

        for(int coin : coins){
            for(int sum=coin;sum<=k;sum++) dp[sum] += dp[sum-coin];
        }

        System.out.print(dp[k]);
    }
}
