import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for(int end=0; end<N; end++) {
            sum += arr[end]; // 구간에 arr[end] 추가

            // 부분합이 S 이상이면 최소 길이 갱신하고 start 이동
            while(sum >= S){
                minLength = Math.min(minLength, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        // 조건 만족하는 구간이 없으면 0 출력
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
