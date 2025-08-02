import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[][] arr = new int[N+1][2];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            if(i+arr[i][0]-1<=N && dp[i+arr[i][0]-1] < dp[i-1]+arr[i][1]) {
                dp[i+arr[i][0]-1] = dp[i-1] + arr[i][1];
                for(int j=i+arr[i][0];j<=N;j++){
                    if(dp[j]>=dp[i+arr[i][0]-1]) break;
                    else dp[j] = dp[i+arr[i][0]-1];
                }
            }
        }

        System.out.println(dp[N]);
    }
}