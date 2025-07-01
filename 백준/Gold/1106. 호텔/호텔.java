import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 고객 수
        int N = Integer.parseInt(st.nextToken()); // 도시 수

        int[][] cities = new int[N][2]; // [비용, 고객 수]

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cities[i][0] = Integer.parseInt(st.nextToken());
            cities[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10001]; // 충분히 큰 크기 설정 필요
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0명 모집하는 비용은 0

        for (int i = 0; i < N; i++) {
            int cost = cities[i][0];
            int customers = cities[i][1];

            for (int j = 0; j + customers < dp.length; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[j + customers] = Math.min(dp[j + customers], dp[j] + cost);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
