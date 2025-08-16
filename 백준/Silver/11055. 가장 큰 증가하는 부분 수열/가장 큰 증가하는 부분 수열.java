import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        
        if(N==1){
            System.out.println(arr[1]); return;
        }

        dp[1] = arr[1];
        for(int i=2;i<=N;i++){
            dp[i] = arr[i]; //혼자 뽑는 경우
            for(int j=1;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]); // ★ 최댓값으로 갱신
                }
            }
        }


        int max = 0;
        for(int i=1;i<=N;i++) max = Math.max(dp[i], max);

        System.out.println(max);
    }
}
