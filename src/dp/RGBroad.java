package dp;
// 백준 | 다이나믹 프로그래밍 | 실버1
// 1149 번 : RGB 거리
// 시간 제한 : 0.5초, 메모리 제한 : 128 MB
// 25.05.29, Bottom-Up 방식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBroad {
    static int[][] arr = new int[1001][3];
    static int[][] dp = new int[1001][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];

        for(int i=1;i<=n;i++){
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }

        int min = dp[n][0];
        for(int i=1;i<3;i++){
            if(min>dp[n][i]) min = dp[n][i];
        }

        System.out.println(min);
    }

}
/*
71 39 44
32 83 55
51 37 63
89 29 100
83 58 11
65 13 15
47 25 29
60 66 19
*/