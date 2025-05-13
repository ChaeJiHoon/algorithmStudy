package dfs_bfs;

import java.util.Scanner;
// 2차원 배열 사용?
// 오른쪽과 아래 인접한 녀석을 확인. 이때 인접한게 하나도 같지 않으면 종료
// 방문 배열 기록해야할듯?
//


public class RedGreenColorBlindness {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strArr = new String[n];

        // 문자 기록 전에 받아두고
        for(int i=0;i<n;i++){
            strArr[i] = sc.nextLine();
        }

        // 문자 기록 배열
        String[][] arr = new String[n][strArr[0].length()];
        // 방문노드
        boolean[][] bool = new boolean[n][strArr[0].length()];

        // 문자 하나하나 다 자르고 2차원 배열에 저장
        for (int i=0; i<n;i++) {
            arr[i] = strArr[i].split("");
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!bool[i][j]){

                }
            }
        }

    }

    static void people(Scanner sc){

    }

    static void rgPeople(){

    }

    static void check(int i, int j, int n, int length, String[][] str){
        // 오른쪽 문자열 확인
        if(0<i && i < n){
            if(str[i][j].equals(str)){

            }
        }

        //아래 문자열 확인
        if(0<j && j<length){

        }
    }
}
