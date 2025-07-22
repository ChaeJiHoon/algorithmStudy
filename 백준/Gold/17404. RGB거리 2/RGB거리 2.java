import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int minCost;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N+1][3];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        minCost = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            // dp[i][c] = i번째 집까지 칠했을 때 c로 칠하는 최소 비용
            int[][] dp = new int[N+1][3];

            // 1번 집 색 고정, 나머지는 큰 값으로 초기화
            for(int c=0;c<3;c++){
                if(c==i)dp[1][c] = arr[1][c];
                else dp[1][c] = 1000000;
            }

            // 나머지 집들 채우기
            for (int j=2;j<=N;j++) {
                dp[j][0] = arr[j][0]+Math.min(dp[j-1][1],dp[j-1][2]);
                dp[j][1] = arr[j][1]+Math.min(dp[j-1][0],dp[j-1][2]);
                dp[j][2] = arr[j][2]+Math.min(dp[j-1][0],dp[j-1][1]);
            }

            // 마지막 집의 색은 첫번짹 색과 다름
            for(int l=0;l<3;l++) {
                if (l==i) continue;
                minCost = Math.min(minCost,dp[N][l]);
            }
        }

        System.out.print(minCost);
    }
}
