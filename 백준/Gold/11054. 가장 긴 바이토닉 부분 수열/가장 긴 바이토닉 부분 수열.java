import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] minDp = new int[N+1];
        int[] maxDp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());

        minDp[N] = 1;
        maxDp[1] = 1;

        for(int i=1;i<=N;i++){
            int maxdp = 0;

            for(int j=i;j>0;j--){
                if(arr[i]>arr[j]){
                    if(maxdp<maxDp[j]) maxdp = maxDp[j];
                }
            }
            maxDp[i] = maxdp+1;
        }

        for(int i=N;i>=0;i--){
            int mindp = 0;

            for(int j=i;j<=N;j++){
                if(arr[i]>arr[j]){
                    if(mindp<minDp[j]) mindp = minDp[j];
                }
            }
            minDp[i] = mindp+1;
        }

        int answer = 0;
        for(int i=0;i<=N;i++) {
            int temp = maxDp[i]+minDp[i];
            if(temp>answer) answer = temp;
        }
        System.out.println(answer-1);
    }
}