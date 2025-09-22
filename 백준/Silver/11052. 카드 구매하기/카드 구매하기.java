import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = arr[1];

        for(int i=2;i<=N;i++){
            int max = arr[i];
            for(int j=1;j<i;j++) max = Math.max(max, dp[i-j]+arr[j]);
            dp[i] = max;
        }

        System.out.println(dp[N]);
    }
}
