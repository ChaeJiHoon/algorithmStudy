package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BallInput {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        for(int i=0;i<m;i++){
            StringTokenizer num = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(num.nextToken());
            int b = Integer.parseInt(num.nextToken());
            int c = Integer.parseInt(num.nextToken());
            for(int j=a;j<=b;j++){
                arr[j] = c;
            }
        }
        for(int i=1;i<arr.length;i++){
            if(i==arr.length-1) System.out.print(arr[i]);
            else System.out.print(arr[i]+ " ");
        }
    }
}
