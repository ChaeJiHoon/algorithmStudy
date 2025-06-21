package dp;
// 백준 | 다이나믹 프로그래밍 | 실버5
// 11660 번 : 구간 합 구하기 5
// 시간 제한 : 1초, 메모리 제한 : 128 MB
// 25.06.16
import java.io.*;
import java.util.*;

public class FindingSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];         // 원본 배열 (1-based)
        int[][] prefixSum = new int[N + 1][N + 1];   // 누적합 배열

        // 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 누적합 계산
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        // 질의 처리
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int result = prefixSum[y2][x2] - prefixSum[y1 - 1][x2]
                    - prefixSum[y2][x1 - 1] + prefixSum[y1 - 1][x1 - 1];

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
