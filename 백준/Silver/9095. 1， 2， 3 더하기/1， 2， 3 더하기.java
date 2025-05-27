import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[12];

        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<=11;i++){
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }

        for(int i=0;i<n;i++){
            int answer = Integer.parseInt(br.readLine());
            System.out.println(dp[answer]);
        }
    }
}
