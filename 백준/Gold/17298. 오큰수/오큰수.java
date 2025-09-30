import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(ans, -1);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i=0;i<N;i++){
            while (!stack.isEmpty() && A[stack.peek()]<A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        for(int i=0;i<N;i++) sb.append(ans[i]).append("\n");
        System.out.print(sb);
    }

}