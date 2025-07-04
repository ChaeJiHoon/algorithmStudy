import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B;
    static int[] heightCount = new int[257]; // 각 높이에 존재하는 블록 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        B = Integer.parseInt(st.nextToken()); // 인벤토리 블록 수

        int minHeight = 256;
        int maxHeight = 0;

        // 입력 받아서 각 높이별 개수 세기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                heightCount[h]++;
                minHeight = Math.min(minHeight, h);
                maxHeight = Math.max(maxHeight, h);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        // 가능한 모든 높이에 대해 시도 (최소 높이 ~ 최대 높이만 탐색)
        for (int target = minHeight; target <= maxHeight; target++) {
            int remove = 0; // 제거할 블록 수
            int add = 0;    // 추가할 블록 수

            for (int h = minHeight; h <= maxHeight; h++) {
                int diff = h - target;

                if (diff > 0) { // 현재 높이가 target보다 높으면 제거
                    remove += diff * heightCount[h];
                } else if (diff < 0) { // 현재 높이가 target보다 낮으면 추가
                    add -= diff * heightCount[h];
                }
            }

            // 인벤토리 블록 + 제거한 블록 >= 필요한 추가 블록일 때만 가능
            if (remove + B >= add) {
                int time = remove * 2 + add;
                if (time <= resultTime) {
                    resultTime = time;
                    resultHeight = target; // 높이는 최대값으로 갱신됨
                }
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}
