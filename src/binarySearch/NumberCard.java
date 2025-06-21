package binarySearch;
// 백준 | 이분탐색 | 실버 5
// 10815 번 : 숫자 카드
// 시간 제한 : 2초, 메모리 제한 : 256 MB
// 25.06.08
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        long[] card = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            card[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());
        long[] number = new long[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) number[i] = Long.parseLong(st.nextToken());

        for(int i=0;i<M;i++){
            long check = number[i];

            int min = 0;
            int max = N;
            int mid = 0;
            boolean trigger = false;
            while(min<max){
                mid = (min+max)/2;
                if(card[mid]==check) {
                    trigger = true;
                    break;
                }else if(card[mid]>check) max = mid;
                else min = mid + 1;
            }
            if(trigger) sb.append("1").append(" ");
            else sb.append("0").append(" ");
        }

        System.out.println(sb.toString().trim());

    }
}
