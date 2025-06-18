import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] dp;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new ArrayList[N+1];
        arr = new ArrayList[N+1];

        for(int i=0;i<=N;i++){
            dp[i] = new ArrayList<>();
            arr[i] = new ArrayList<>();
        }

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            for(int j=0;j<size;j++){
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // dp 처음은 첫번째 녀석
        dp[1].add(arr[1].get(0)); // 첫 번째 줄 초기화

        for (int i=2;i<=N;i++) {
            for (int j=0;j<i;j++) {
                if(j==0){
                    dp[i].add(dp[i-1].get(0)+arr[i].get(0));
                }else if(j==i-1){
                    dp[i].add(dp[i-1].get(j-1)+arr[i].get(j));
                }else{
                    int maxPrev = Math.max(dp[i-1].get(j-1), dp[i-1].get(j));
                    dp[i].add(maxPrev + arr[i].get(j));
                }
            }
        }
        
        System.out.println(Collections.max(dp[N]));

    }
}
