import java.io.*;
import java.util.*;

// 전략, 그 칸에서 가장 큰 DP를 구한다,
// 현재 그 칸(arr[i][j])와 바로 윗 칸 의 DP(bigDp[i-1][j-1]),(bigDp[i-1][j]),(bigDp[i-1][j+1]) 의 최댓값을 구한다
// 이때 위에 0 <= j, 3 > j 를 만족시키는 것 또한 킥 포인트

public class Main {

    static int N;
    static int[][] arr;
    static int[][] bigDp;
    static int[][] smallDp;
    static int[] dc = {-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][3];
        bigDp = new int[N+1][3];
        smallDp = new int[N+1][3];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        biggest();
        smallest();

        int bigNum = Math.max(Math.max(bigDp[N][0], bigDp[N][1]),bigDp[N][2]);
        int smallNum = Math.min(Math.min(smallDp[N][0], smallDp[N][1]),smallDp[N][2]);

        System.out.println(bigNum+" "+smallNum);
    }

    static void biggest(){
        for(int i=1;i<=N;i++){
            bigDp[i][0] = Math.max(bigDp[i-1][0], bigDp[i-1][1]) + arr[i][0];
            bigDp[i][1] = Math.max(Math.max(bigDp[i-1][0], bigDp[i-1][1]),bigDp[i-1][2]) + arr[i][1];
            bigDp[i][2] = Math.max(bigDp[i-1][1], bigDp[i-1][2]) + arr[i][2];
        }
    }

    static void smallest(){
        for(int i=1;i<=N;i++){
            smallDp[i][0] = Math.min(smallDp[i-1][0], smallDp[i-1][1]) + arr[i][0];
            smallDp[i][1] = Math.min(Math.min(smallDp[i-1][0], smallDp[i-1][1]),smallDp[i-1][2]) + arr[i][1];
            smallDp[i][2] = Math.min(smallDp[i-1][1], smallDp[i-1][2]) + arr[i][2];
        }
    }
}
