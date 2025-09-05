import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int k = 1;
        int sum = 1;

        // N이 속한 대각선 찾기
        while (sum < N) {
            k++;
            sum += k;
        }

        // 대각선에서의 위치
        int pos = N - (sum - k);

        int numerator, denominator;

        if (k % 2 == 0) { // 짝수 대각선 → 아래에서 위
            numerator = pos;
            denominator = k - pos + 1;
        } else { // 홀수 대각선 → 위에서 아래
            numerator = k - pos + 1;
            denominator = pos;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
