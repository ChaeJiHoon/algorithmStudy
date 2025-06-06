package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 | 에라토스테네스의 체 | 실버 3
// 1929 번 : 소수 구하기
// 시간 제한 : 2초, 메모리 제한 : 256 MB
// 25.06.03

public class PrimeFinding {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        prime = new boolean[n+1];

        // 0과 1은 소수가 아님
        prime[0] = true;
        prime[1] = true;

        for(int i=0;i<Math.sqrt(n);i++){
            if(prime[i]) continue;

            for(int j=i*i;j<prime.length;j=j+i){
                prime[j] = true;
            }
        }

        for(int i=m;i<=n;i++){
            if(!prime[i]) sb.append(i).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

}
