package DivideConquer;
// 백준 | 분할정복 | 실버 1
// 10830 번 : 행렬 제곱
// 시간 제한 : 1초, 메모리 제한 : 256 MB
// 25.06.07

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixSquare {
    static long[][] preMatrix;

    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[][] matrix = new long[n][n];
        preMatrix = new long[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                long num = Long.parseLong(st.nextToken());
                matrix[i][j] = num;
                preMatrix[i][j] = num;
            }
        }
        matrix = func(matrix,b);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static long[][] func(long[][] arr, long ex){
        if(ex==1){
            return arr;
        }

        long[][] temp = func(arr,ex/2);

        if(ex%2==1){
            long[][] newArr = new long[n][n];
            arr = square(temp);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    long sum = 0;
                    for(int k=0;k<n;k++){
                        sum += arr[i][k]*preMatrix[k][j];
                    }
                    newArr[i][j] = sum % 1000;
                }
            }
            return newArr;
        }else{
            return square(temp);
        }
    }

    static long[][] square(long[][] arr){
        long[][] newArr = new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = 0;
                for(int k=0;k<n;k++){
                    sum += arr[i][k]*arr[k][j];
                }
                newArr[i][j] = sum % 1000;
            }
        }
        return newArr;
    }
}
