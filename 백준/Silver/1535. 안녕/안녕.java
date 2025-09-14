import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ple = new int[N+1];
        int[] life = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) life[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) ple[i] = Integer.parseInt(st.nextToken());

        int ca = 99;
        int[] dp = new int[ca+1];

        for (int i=1;i<=N;i++) {
            int c = life[i];
            int v = ple[i];

            for(int j=ca;j>=c;j--) dp[j] = Math.max(dp[j], dp[j-c]+v);
        }

        System.out.println(dp[ca]);
    }


}