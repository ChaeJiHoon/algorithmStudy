package DivideConquer;
// 백준 | 분할정복 | 실버 1
// 10830 번 : 행렬 제곱
// 시간 제한 : 1초, 메모리 제한 : 256 MB
// 25.06.07

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixSquare_refactoring {
    static int[][] origin;
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        origin = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                origin[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }

        int[][] result = func(origin,b);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static int[][] func(int[][] arr, long ex){

        if(ex==1) return arr;

        int[][] ret = func(arr,ex/2);

        ret = square(ret, ret);

        if(ex%2==1) ret = square(ret,origin);

        return ret;


    }

    static int[][] square(int[][] ar1, int[][] ar2){
        int[][] newArr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    newArr[i][j] += ar1[i][k] * ar2[k][j];
                    newArr[i][j] %= 1000;
                }

            }
        }
        return newArr;
    }
}
