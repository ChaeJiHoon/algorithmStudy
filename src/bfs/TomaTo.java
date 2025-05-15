package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomaTo {
    static int cnt = 0;
    static int[][] map;
    static boolean[][] visit;
    static int x_weight;
    static int y_length;
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max=0;


        x_weight = sc.nextInt();
        y_length = sc.nextInt();

        sc.nextLine();

        map= new int[y_length][x_weight];
        visit = new boolean[y_length][x_weight];

        for(int i=0;i<y_length;i++){
            String[] tomato = sc.nextLine().split(" ");
            for(int j=0;j<x_weight;j++){
                map[i][j] = Integer.parseInt(tomato[j]);
            }

        }


        for(int i=0;i<y_length;i++){
            for(int j=0;j<x_weight;j++){
                if(map[i][j]==1 && !visit[i][j]){  // 방문 안했을때만
                    int[] ar = {i,j};
                    q.add(ar);                      // q에다가 첫번째 익은 토마토 다 넣음
                }
            }
        }

        do{
            bfs(q.poll());
        }while(!q.isEmpty());

        System.out.println(check()-1);

    }
    // 0 0 0 0 0 0
    static void bfs(int[] arr){
        if(visit[arr[0]][arr[1]]) return;  // 방문 했을 경우 종료
        visit[arr[0]][arr[1]] = true;


        for(int i=0;i<4;i++){
            int nextX = arr[1] + dx[i];
            int nextY = arr[0] + dy[i];

            if(nextX<0 || nextY<0 || x_weight<=nextX || y_length<=nextY) continue;
            if(map[nextY][nextX]!=0 || visit[nextY][nextX]) continue;

            map[nextY][nextX] = map[arr[0]][arr[1]] + 1;

            q.add(new int[]{nextY,nextX});
        }
    }

    static int check(){
        int max = 0;

        for(int i=0;i<y_length;i++){
            for(int j=0;j<x_weight;j++){
                System.out.print(map[i][j] + " ");
                if(max<map[i][j]) max = map[i][j];

                if(map[i][j]==0){
                    return 0;
                }
            }
            System.out.println();
        }
        return max;
    }
}
