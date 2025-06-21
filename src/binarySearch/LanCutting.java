package binarySearch;
// 백준 | 이분탐색 | 실버 2
// 1654 번 : 랜선 자르기
// 시간 제한 : 2초, 메모리 제한 : 128 MB
// 25.06.08
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LanCutting {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] Lan = new int[K];
        long max = 0;
        long min = 0;
        long mid = 0;
        for(int i=0;i<K;i++){
            Lan[i] = Integer.parseInt(br.readLine());
            if(max<Lan[i]) max = Lan[i];
        }

        max++;
        while(min<max){
            mid = (max+min)/2;
            long sum = 0;

            for (int lan : Lan) {
                sum += lan/mid;
            }

            if(sum<N) max = mid;
            else min = mid+1;
        }

        System.out.println(min-1);
    }
}
