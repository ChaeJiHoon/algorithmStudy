import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        boolean[][] check = new boolean[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++) arr[i][j] = str.charAt(j);
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                if(arr[i][j]=='Y'){
                    check[i][j] = true;
                    for(int k=0;k<N;k++) if(arr[j][k]=='Y') check[i][k]= true;
                }
            }
        }

        int max = 0;

        for(int i=0;i<N;i++){
            int cnt = 0;
            for(int j=0;j<N;j++) if(i!=j && check[i][j]) cnt++;
            max = Math.max(cnt,max);
        }

        System.out.println(max);
    }

}