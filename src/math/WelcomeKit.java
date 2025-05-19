package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WelcomeKit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer stp = new StringTokenizer(br.readLine());

        int tshirt = Integer.parseInt(stp.nextToken());
        int pen = Integer.parseInt(stp.nextToken());

        int tcount = 0;
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            tcount += (num + tshirt - 1) / tshirt;  // 티셔츠 개수 계산 (올림)
        }
        System.out.println(tcount);

        int p1 = (n + pen - 1) / pen;  // 필요한 펜 수
        int p2 = n % pen;              // 남는 학생 수
        System.out.println(p1 + " " + p2);
    }
}
