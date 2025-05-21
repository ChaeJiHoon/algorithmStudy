package greedy;

import java.io.*;

// 백준 | 그리디 | 실버4
// 2839 번 : 설탕 배달
// 시간 제한 : 1초, 메모리 제한 : 128 MB
public class SugarDelivery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(func(n));
    }

    public static int func(int n){  // n=5
        int count = n/5;     // 5의 갯수가 몇개 필요한지 카운트, 5를 넘는 순간을 판단
        int m = 0;          // 실질적인 카운트

        for(int i=count;i>=0;i--){
            m = 5*i;  // m = 20
            for(int j=0;j<=4;j++){
                if(m+j*3==n) return i+j;
                if(m+j*3>n) break;
            }
        }
        return -1;
    }
}
