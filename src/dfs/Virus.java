package dfs;
// 백준 실버3 dfs
// 2606, 바이러스


import java.util.Scanner;

public class Virus {
    static boolean[] visit;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computer = sc.nextInt();
        int line = sc.nextInt();
        arr = new int[line][line];

        visit = new boolean[computer];

        for(int i=0; i<line;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 당사자노드와 이어진 노드만 1로 채움

            // 당사자 노드
            arr[line][line] = 1;
            // 이어진 노드
            arr[x][y] = 1;
        }

        for(int i=0;i<line;i++){

        }
    }

    private static void dfs(int line){
        if(visit[line]) return;
        visit[line] = true;
        dfs(line);
    }
}
