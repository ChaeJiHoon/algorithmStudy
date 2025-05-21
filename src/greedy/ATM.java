package greedy;
// 백준 | 그리디 | 실버4
// 11399 번 : ATM
// 시간 제한 : 1초, 메모리 제한 : 256 MB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        int answer =0;

        for (int i=0;i<n;i++) {
            sum += arr[i];
            answer += sum;
        }

        System.out.println(answer);
    }
}
