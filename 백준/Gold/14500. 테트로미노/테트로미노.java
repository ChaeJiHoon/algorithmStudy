import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 칸에 대해 DFS + ㅗ 모양 예외처리
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                visited[y][x] = true;
                dfs(x, y, map[y][x], 1);
                visited[y][x] = false;
                checkExtraShape(x, y); // ㅗ, ㅜ, ㅓ, ㅏ 예외 처리
            }
        }

        System.out.println(max);
    }

    // DFS로 가능한 도형 탐색
    static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(nx, ny, sum + map[ny][nx], depth + 1);
            visited[ny][nx] = false;
        }
    }

    // ㅗ, ㅜ, ㅓ, ㅏ 모양은 DFS로 만들 수 없으므로 별도 체크
    static void checkExtraShape(int x, int y) {
        // 중심 포함 + 3방향
        int[][] shapes = {
                {0, 0, -1, 0, 0, -1, 1, 0},  // ㅗ
                {0, 0, -1, 0, 1, 0, 0, 1},   // ㅜ
                {0, 0, 0, -1, 0, 1, 1, 0},   // ㅏ
                {0, 0, 0, -1, 0, 1, -1, 0}   // ㅓ
        };

        for (int[] shape : shapes) {
            boolean isValid = true;
            int sum = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + shape[i * 2 + 1];
                int ny = y + shape[i * 2];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    isValid = false;
                    break;
                }

                sum += map[ny][nx];
            }

            if (isValid) max = Math.max(max, sum);
        }
    }
}
