import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static String A,B;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        int n = A.length();
        int m = B.length();

        dp = new int[n+1][m+1];

        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if(A.charAt(i-1)==B.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        String result = backTracking(n,m);
        System.out.println(result.length());
        if(!result.isEmpty()) System.out.println(result);

    }

    static String backTracking(int i, int j){
        StringBuffer sb = new StringBuffer();

        while(i>0 && j>0){
            if(A.charAt(i-1)==B.charAt(j-1)){
                sb.append(A.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] >= dp[i][j-1]){
                i--;
            }else j--;
        }
        
        return sb.reverse().toString();
    }
}
