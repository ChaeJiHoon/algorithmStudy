package dfs_bfs;

import java.util.Scanner;
// 백준, 골드 5, DFS
// 10026번, 적록 색약


public class RedGreenColorBlindness {
    static int countA = 0;
    static int countB = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static String[][] check;
    static boolean[][] visit;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        String[] strArr = new String[n];

        // 문자 기록 전에 받아두고
        for(int i=0;i<n;i++){
            strArr[i] = sc.nextLine();
        }
        // 문자 기록 배열
        check = new String[n][n];

        // 문자 하나하나 다 자르고 2차원 배열에 저장
        for (int i=0; i<n;i++) {
            check[i] = strArr[i].split("");
        }

        //방문 노드
        visit = new boolean[n][n];
        // 일반인
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    dfs(i,j,check[i][j]);
                    countA++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j].equals("R")){
                    check[i][j] = "G";
                }
            }
        }

        // 방문 노드 초기화
        visit = new boolean[n][n];
        // 적록 색맹인
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    dfs(i,j,check[i][j]);
                    countB++;
                }
            }
        }

        System.out.println(countA + " " + countB);

    }


    static void dfs(int x, int y, String target){
        if(visit[x][y]) return;
        // 함수가 실행되는 순간 방문
        visit[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x +dx[i];
            int ny = y +dy[i];

            // 모서리가 아니면서 방문할 노드와 방문 중인 노드가 같은 경우 함수 호출
            if(nx>=0 && ny>=0 && nx<n && ny<n && check[nx][ny].equals(target)){
                dfs(nx, ny, target);
            }
        }

    }
}
