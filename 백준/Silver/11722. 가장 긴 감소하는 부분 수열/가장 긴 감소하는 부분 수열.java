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

        dp[1] = 1;

        for(int i=1;i<=N;i++){
            int mindp = 0;

            for(int j=i;j>0;j--){
                if(arr[i]<arr[j]){                      // 즉 현재 값이 이전 수보다 큰 애중
                    if(mindp<dp[j]) mindp = dp[j];      // 감소 했던 값이 제일 큰 녀석의 dp 값을 가져온다
                }
            }
            dp[i] = mindp+1;                            // 그러고 현재 값의 dp를 1 추가
        }
        int answer = 0;
        for(int i=0;i<=N;i++) if(dp[i]>answer) answer = dp[i];
        System.out.println(answer);
    }
}