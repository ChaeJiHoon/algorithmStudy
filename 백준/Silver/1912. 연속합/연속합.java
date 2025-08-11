import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = arr[1];

        int acc = arr[1];
        for(int i=2;i<=N;i++){
            acc = Math.max(arr[i], acc + arr[i]);  // 현재 위치에서 끝나는 최대 연속합
            dp[i] = Math.max(dp[i-1], acc);        // 전역 최대값 갱신
        }
        System.out.println(dp[N]);

    }
}
