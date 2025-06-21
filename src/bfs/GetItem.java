package bfs;


import java.util.*;
public class GetItem {
    public static void main(String[] args){
        Solution1 sol = new Solution1();
        int[][] arr = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int[][] arr1 = {{1,1,5,7}};
        System.out.println(sol.solution(arr, 1,3,7,8));
        //System.out.println(sol.solution(arr1, 1,1,4,7));
        sol.map[8][7]=99;
        for(int i=0;i<52;i++){
            for(int j=0;j<52;j++){
                System.out.print(sol.map[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }
}



class Solution1 {
    // 0과 51을 두어 빈공간을 만들어 둠
    static int[][] map = new int[52][52];
    static boolean[][] visited = new boolean[52][52];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {


        // 1. 사각형 모두 1로 초기화, 1로 칠하는거로 보면 된다.
        for(int[] rec : rectangle){
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];

            for(int i=y1;i<=y2;i++){
                for(int j=x1;j<=x2;j++){
                    map[i][j] = 1;
                }
            }
        }
        // 2. 사각형 외부를 순회하면서 찾아나감
        changeSide(characterX, characterY, itemX, itemY);

        return map[itemY][itemX];
    }

    static void changeSide(int startX, int startY, int itemX, int itemY){
        // 아래와 같이 짜면 대각선을 확인할수 있음, 대각선이 0이면 bfs 추가
        int[] cx = {-1,-1,1,1};
        int[] cy = {1,-1,-1,1};

        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX,startY});
        visited[startY][startX] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==itemX && now[1]==itemY) return;

            for(int i=0;i<4;i++){
                boolean trigger = false;
                // 상하좌우 좌표
                int newX = now[0]+dx[i];
                int newY = now[1]+dy[i];

                // 다음 좌표가 0보다 작거나 50보다 크면 넘어감
                if(0>newX || 0>newY || newX>50 || newY>50) continue;
                // 다음 좌표가 1이 아니면 넘어감
                if(map[newY][newX]!=1) continue;


                // 상하좌우 좌표의 상하좌우, 대각선 좌표
                for(int j=0;j<4;j++){
                    int check1X = newX + cx[j];
                    int check1Y = newY + cy[j];
                    int check2X = newX + dx[j];
                    int check2Y = newY + dy[j];

                    // 모서리인것이 확인이 되면 트리거를 바꿈
                    if(map[check1Y][check1X]==0 || map[check2Y][check2X]==0 ) {
                        trigger = true;
                        break;
                    }
                }
                // 모서리이고 방문 안했으면
                if(trigger && !visited[newY][newX]){
                    map[newY][newX] = map[now[1]][now[0]]+1;
                    q.add(new int[]{newX,newY});
                }

            }

        }

    }
}