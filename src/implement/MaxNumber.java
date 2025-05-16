package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int min = 1000000;
        int max = -1000000;

        int[] arr = new int[n];
        int leng = st.countTokens();

        for(int i=0;i<leng;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<leng;i++){
            if(max<arr[i]) {
                max = arr[i];
            }
            if(min>arr[i]){
                min = arr[i];
            }
        }

        sb.append(min + " " + max);
        System.out.println(sb);

    }
}
