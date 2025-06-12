import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         arr = new int[N];

         st = new StringTokenizer(br.readLine());
         for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
         }

         Arrays.sort(arr);

         for(int i=0;i<N;i++){
             backTrackingFunc(0,arr[i]+"");
         }

         System.out.println(sb.toString());

    }

    static void backTrackingFunc(int depth, String str){
        depth++;

        if(depth==M){
            sb.append(str).append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            backTrackingFunc(depth, str+" "+arr[i]);
        }
    }

}
