import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        for(int i=2;i<=9;i++) dp[i] = dp[i-1]+1;

        for(int i=10;i<=1000;i++){
            dp[i] += dp[i-1];
            String num = String.valueOf(i);
            int n = num.charAt(0)-num.charAt(1);
            boolean trigger = true;

            for(int j=0;j<num.length()-1;j++) {
                if(n!=num.charAt(j)-num.charAt(j+1)){
                    trigger = false;
                    break;
                }
            }

            if(trigger) dp[i]++;
        }

        System.out.println(dp[N]);
    }
}
