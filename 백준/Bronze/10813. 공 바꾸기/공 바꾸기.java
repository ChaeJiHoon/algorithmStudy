import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++) arr[i] = i;

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 버블 정렬
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        for(int i=1;i<=n;i++) sb.append(arr[i]).append(" ");

        System.out.println(sb.toString().trim());
    }
}
