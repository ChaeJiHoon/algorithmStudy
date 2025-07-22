import java.io.*;
import java.util.*;

public class Main {
    static long[] answer = new long[3];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] liquid = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) liquid[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(liquid);

        long min = Long.MAX_VALUE;

        // 고정 포인터 + 투포인터 구조
        for(int i=0;i<N-2;i++){
            int left = i+1;
            int right = N-1;

            while(left<right){
                long sum = liquid[i]+liquid[left]+liquid[right];

                if(Math.abs(sum)<min){
                    min = Math.abs(sum);
                    answer[0] = liquid[i];
                    answer[1] = liquid[left];
                    answer[2] = liquid[right];
                }

                if(sum>0) right--;
                else left++;
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
