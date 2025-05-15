package dfs;

import java.util.*;

public class Numbering {
    static boolean[][] visited;
    static String[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        visited = new boolean[n][n];
        map = new String[n][n];

        // 지도 제작
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] strArr = str.split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = strArr[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("1") && !visited[i][j]) {
                    int cnt = dfs(i, j, 0);
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result); // 오름차순 정렬
        System.out.println(result.size()); // 총 단지 수 출력
        for (int num : result) {
            System.out.println(num); // 각 단지의 집 수 출력
        }
    }

    private static int dfs(int i, int j, int count) {
        visited[i][j] = true;
        count++;

        for (int k = 0; k < 4; k++) {
            int ni = i + dy[k];
            int nj = j + dx[k];
            if (ni >= 0 && nj >= 0 && ni < n && nj < n &&
                    !visited[ni][nj] && map[ni][nj].equals("1")) {
                count = dfs(ni, nj, count);
            }
        }

        return count;
    }
}
