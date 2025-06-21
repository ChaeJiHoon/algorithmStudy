package dp;
// 백준 | 다이나믹 프로그래밍 | 실버1
// 9465 번 : 스티커
// 시간 제한 : 1초, 메모리 제한 : 256 MB
// 25.06.18
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n];
            int[][] cost = new int[2][n];

            for(int i=0;i<2;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) cost[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = cost[0][0];
            dp[1][0] = cost[1][0];

            int max = Math.max(dp[0][0], dp[1][0]);

            for(int i=1;i<n;i++){
                if(i==1){
                    dp[0][1] = dp[1][0] + cost[0][1];
                    dp[1][1] = dp[0][0] + cost[1][1];
                    max = Math.max(dp[0][i], dp[1][i]);
                }else{
                    dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + cost[0][i];
                    dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + cost[1][i];
                }
                max = Math.max(max,Math.max(dp[0][i], dp[1][i]));
            }

            sb.append(max).append("\n");

        }
        System.out.println(sb.toString().trim());
    }
}
