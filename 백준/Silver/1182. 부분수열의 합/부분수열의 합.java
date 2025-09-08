import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static long cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);

        // 빈 부분수열 제외
        if(S==0) cnt--;

        System.out.println(cnt);
    }

    static void dfs(int idx, int sum){
        if(idx==N){
            if(sum==S)cnt++;
            return;
        }
        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum);
    }
}
