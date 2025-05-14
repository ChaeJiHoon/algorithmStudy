package dfs_bfs;

import java.util.Scanner;

public class NumberConnect {
    static int M;
    static int N;
    static boolean[] visited;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정점의 개수
        N = sc.nextInt();
        // 간선의 개수
        M = sc.nextInt();

        visited = new boolean[N + 1];
        map = new int[N + 1][N + 1];

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        // 모든 정점 검사
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int x) {
        visited[x] = true;
        for (int i = 1; i <= N; i++) {
            if (map[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
