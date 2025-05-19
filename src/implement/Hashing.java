package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer =0;

        for(int i=0;i<n;i++){
            long num = 1;
            for(int j=0;j<i;j++){
                num *= 31%1234567891;
            }
            answer = num*(str.charAt(i)-96)%1234567891;
        }
        System.out.println(answer);
    }
}
