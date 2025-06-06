package DivideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixSquare {
    static int[][] matrix;
    static int[][] prematrix;
    static int[][] multi;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
            }
        }



    }


}
