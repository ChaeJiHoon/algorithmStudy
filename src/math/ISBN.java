package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ISBN {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        int missingIndex = -1;
        int sum = 0;

        for (int i = 0; i < 13; i++) {
            char ch = isbn.charAt(i);
            if (ch == '*') {
                missingIndex = i;
                continue;
            }

            int num = ch - '0';
            if ((i + 1) % 2 == 0) { // 자리 수가 짝수이면 가중치 3
                sum += num * 3;
            } else { // 자리 수가 홀수이면 가중치 1
                sum += num;
            }
        }

        // 이제 0부터 9까지 넣어보고 유효한 값 찾기
        for (int i = 0; i <= 9; i++) {
            int tempSum = sum;
            if ((missingIndex + 1) % 2 == 0) {
                tempSum += i * 3;
            } else {
                tempSum += i;
            }

            if (tempSum % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
