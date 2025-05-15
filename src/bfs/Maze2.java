package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 실버1 2178 미로탐색
// bfs
public class Maze2 {
    static int N; // 세로
    static int M; // 가로
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // 세로
        M = sc.nextInt();  // 가로
        sc.nextLine();

        visit = new boolean[N][M];
        map = new int[N][M];

        for(int i=0;i<N;i++){
            String[] str = sc.nextLine().split("");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(bfs(0,0));

    }

    private static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        int[] arr = {x,y};
        q.add(arr);
        visit[x][y] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0;i<4;i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 하나라도 모서리인 경우 넘어감
                if(nextX<0 || nextY<0 || nextX >= N || nextY>= M) continue;
                // 방문했거나, 0 이면 넘어감
                if(visit[nextX][nextY] || map[nextX][nextY]==0)  continue;

                // 모든 조건 만족하면

                // 방문 처리
                visit[nextX][nextY] = true;

                // 맵에 이동거리 기록하기
                map[nextX][nextY] = map[nowX][nowY] +1 ;
                q.add(new int[]{nextX,nextY});
            }
        }

        return map[N-1][M-1];
    }
}
