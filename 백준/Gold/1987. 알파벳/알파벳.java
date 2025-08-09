import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max = 0;
    static char[][] board;
    static boolean[] used = new boolean[26];
    static final int[] dy = { -1, 1, 0, 0 };
    static final int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for(int i=0;i<R;i++){
            String line = br.readLine();
            for (int j=0;j<C;j++) board[i][j] = line.charAt(j);
        }

        used[board[0][0]-'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int y, int x, int depth) {
        max = Math.max(max, depth);

        for (int d=0;d<4;d++){
            int ny=y+dy[d], nx=x+dx[d];
            if (ny<0||nx<0||ny>=R||nx >= C) continue;

            int idx = board[ny][nx]-'A';
            if (!used[idx]){
                used[idx] = true;
                dfs(ny, nx, depth + 1);
                used[idx] = false; // 백트래킹
            }
        }
    }
}
