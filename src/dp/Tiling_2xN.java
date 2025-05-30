package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 | 다이나믹 프로그래밍 | 실버3
// 11726 번 : 2XN 타일링
// 시간 제한 : 1초, 메모리 제한 : 256 MB
// 25.05.29, Bottom-Up 방식
public class Tiling_2xN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3;i<=n;i++){
            arr[i] = (arr[i-2]+arr[i-1])%10007;
        }

        System.out.println(arr[n]%10007);

    }
}
