import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력: 물건의 수 N, 배낭 최대 무게 K
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 물건 수
        int K = Integer.parseInt(st.nextToken());  // 최대 배낭 무게

        // 각 물건의 무게와 가치를 저장할 배열
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        // 물건 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());  // 무게
            values[i] = Integer.parseInt(st.nextToken());   // 가치
        }

        // dp[i][j] : i번째 물건까지 고려했을 때, 무게 j 이하에서 얻을 수 있는 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // DP 테이블 채우기
        for (int i=1;i<=N;i++) {           // i번째 물건까지 고려
            for (int j=0;j<=K;j++) {       // 현재 배낭의 용량 j 예시는 7까지
                if (weights[i]>j) {        // weights[i] 현재 물건의 무게
                    // 현재 물건의 무게가 배낭 용량보다 크면 못 넣는다
                    dp[i][j]=dp[i-1][j];
                } else {
                    // 현재 물건을 안 넣는 경우 vs 넣는 경우 중 최대값 선택
                    dp[i][j] = Math.max(
                            dp[i-1][j],  // 안 넣는 경우
                            dp[i-1][j-weights[i]] + values[i]  // 넣는 경우 -> (배낭 용량 - 물건의 무게) (7 - 3 =4)
                            //dp[3][7] = Math.max(dp[2][7],dp[2][4]=8 + values[3] = 6) 
                    );
                }
            }
        }

        // 최대 가치 출력
        System.out.println(dp[N][K]);
    }
}
