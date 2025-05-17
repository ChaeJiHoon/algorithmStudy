package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0 ;

        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num ==1) {
                count++;
                continue;
            }
            for(int j=2;j<num/2+1;j++){
                if(num%j == 0) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(n-count);

    }
}
