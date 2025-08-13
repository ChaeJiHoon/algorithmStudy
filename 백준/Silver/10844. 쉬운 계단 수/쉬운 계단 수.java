import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[10]; // 0 ~ 9
        for(int i=1;i<=9;i++) dp[i]++;

        for(int i=2;i<=n;i++){
            long[] temp = new long[10];
            for(int j=0;j<=9;j++){
                if(j==0) temp[1] += dp[0]%1000000000;
                else if(j==9) temp[8] += dp[9]%1000000000;
                else {
                    temp[j-1] += dp[j]%1000000000;
                    temp[j+1] += dp[j]%1000000000;
                }
            }

            System.arraycopy(temp, 0, dp, 0, 10);
        }

        long answer = 0;
        for(long i : dp) answer += i;

        System.out.print(answer%1000000000);
    }
}
