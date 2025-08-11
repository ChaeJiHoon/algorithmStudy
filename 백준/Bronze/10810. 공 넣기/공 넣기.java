import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        for(int i=0;i<m;i++){
            StringTokenizer num = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(num.nextToken());
            int b = Integer.parseInt(num.nextToken());
            int c = Integer.parseInt(num.nextToken());
            for(int j=a;j<=b;j++)arr[j] = c;
        }
        
        for(int i=1;i<arr.length;i++) sb.append(arr[i]).append(" ");
        System.out.print(sb.toString().trim());
    }
}
