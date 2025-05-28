package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());

        int num = 1;
        int kum = 1;

        for(int i=n-k+1;i<=n;i++){
            num = num*i;
        }
        for(int i=1;i<=k;i++){
            kum = kum*i;
        }

        System.out.println(num/kum);

    }
}
