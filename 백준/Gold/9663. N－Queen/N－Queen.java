import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2*N];
        diag2 = new boolean[2*N];

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int r) {
        if(r==N){
            cnt++;
            return;
        }

        for(int c=0;c<N;c++){
            int d1 = r+c;
            int d2 = r-c + (N-1);
            if (col[c] || diag1[d1] || diag2[d2]) continue;

            col[c] = diag1[d1] = diag2[d2] = true;
            dfs(r+1);
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}
