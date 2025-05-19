package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing2 {
    public static void main(String[] args) throws IOException {
        final int r = 31;
        final int M = 1234567891;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long hash = 0;
        long pow = 1;

        for(int i = 0; i < n; i++) {
            int charValue = str.charAt(i) - 'a' + 1;
            hash = (hash + (charValue * pow) % M) % M;
            pow = (pow * r) % M;
        }

        System.out.println(hash);
    }
}
