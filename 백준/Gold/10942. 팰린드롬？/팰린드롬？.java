import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[][] dp;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        
        // 길이가 1일 때
        for(int i=1;i<=N;i++) dp[i][i] = true;

        // 길이가 2일 때
        for(int i=1;i<N;i++) if(arr[i]==arr[i+1]) dp[i][i+1] = true;

        // 길이 3 이상
        for(int len=3;len<=N;len++){
            for(int start=1;start<=N-len+1;start++){
                int end = start + len - 1;
                if(arr[start]==arr[end]&&dp[start+1][end-1]){
                    dp[start][end] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e] ? 1 : 0).append("\n");
        }

        System.out.print(sb.toString());
    }
}
