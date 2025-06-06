package DivideConquer;
// 백준 | 분할정복 | 실버 1
// 1992 번 : 쿼드 트리
// 시간 제한 : 2초, 메모리 제한 : 128 MB
// 25.06.05

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuadTree {
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(quad(0,0,n));
    }

    static String quad(int row, int col, int size) {
        if (isSame(row, col, size)) {
            return Integer.toString(map[row][col]);
        }

        int half = size / 2;

        return "("
                + quad(row, col, half)                   // 왼쪽 위
                + quad(row, col + half, half)            // 오른쪽 위
                + quad(row + half, col, half)            // 왼쪽 아래
                + quad(row + half, col + half, half)     // 오른쪽 아래
                + ")";
    }

    static boolean isSame(int row, int col, int size) {
        int val = map[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != val) return false;
            }
        }
        return true;
    }
}
