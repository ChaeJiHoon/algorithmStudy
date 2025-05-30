package math;
// 백준 | 수학 | 실버5
// 1676 번 : 팩토리얼의 0의 개수
// 시간 제한 : 2초, 메모리 제한 : 128 MB
// 25.05.30

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialZeroNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        while(n>=5){
            answer += n/5;
            n /= 5;
        }

        System.out.println(answer);

    }
}
