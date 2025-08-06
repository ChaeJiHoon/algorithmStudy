import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2]; // 상담에 걸리는 시간
        int[] P = new int[N + 2]; // 상담 수익
        int[] dp = new int[N + 2]; // i일까지 얻을 수 있는 최대 수익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N + 1; i++) {
            // 이전까지의 최대 수익이 더 클 수도 있음
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int endDay = i + T[i] - 1;
            if (endDay <= N) {
                dp[endDay + 1] = Math.max(dp[endDay + 1], dp[i] + P[i]);
            }
        }

        // 최댓값 탐색
        int answer = 0;
        for (int i = 1; i <= N + 1; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
