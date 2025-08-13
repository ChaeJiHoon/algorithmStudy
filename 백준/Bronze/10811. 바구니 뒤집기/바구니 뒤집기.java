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

        for(int i=1;i<=n;i++) arr[i] = i;

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int mid;
            if((b-a)%2==1) mid = (b-a)/2+1;
            else mid = (b-a)/2;

            for(int i=0;i<mid;i++){
                int tmp = arr[a+i];
                arr[a+i] = arr[b-i];
                arr[b-i] = tmp;
            }
        }

        for(int i=1;i<arr.length;i++) sb.append(arr[i]).append(" ");
        System.out.print(sb.toString().trim());
    }
}
