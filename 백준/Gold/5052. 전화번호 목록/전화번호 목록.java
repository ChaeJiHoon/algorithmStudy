import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            String[] a = new String[N];

            for (int i=0;i<N;i++) a[i] = br.readLine();

            Arrays.sort(a);
            boolean trigger = true;

            for (int i=0;i<N-1;i++) {
                if (a[i+1].startsWith(a[i])) {
                    trigger = false; break;
                }
            }
            sb.append(trigger ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
}
