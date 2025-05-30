package dp;
// 백준 | 다이나믹 프로그래밍 | 실버2
// 11053 번 : 가장 긴 증가하는 부분 수열
// 시간 제한 : 1초, 메모리 제한 : 128 MB
// 25.05.30, Bottom-Up 방식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;

        for(int i=1;i<=n;i++){
            int maxdp = 0;

            for(int j=i;j>0;j--){
                if(arr[i]>arr[j]){                      // arr[i] 값이 arr[j]보다 크면서, 즉 현재 값이 이전 수보다 큰 애중
                    if(maxdp<dp[j]) maxdp = dp[j];      // 증가 했던 값이 제일 큰 녀석의 dp 값을 가져온다
                }
            }
            dp[i] = maxdp+1;                            // 그러고 현재 값의 dp를 1 추가
        }

        int answer = 0;
        for(int i=1;i<=n;i++){
            if(dp[i]>answer) answer = dp[i];
        }
        System.out.println(answer);

    }


}
