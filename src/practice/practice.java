package practice;

import java.util.*;

public class practice {
    // 좌표
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    // 맵
    static int[][] box;
    static int answer = 0;

    static void bfs(int n, int m) {
        // 위에서 부터 처리할 큐 선언
        Queue<Point> Q = new LinkedList<>();

        // 1이 있는 경우 큐에 삽입
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(box[i][j]==1) Q.offer(new Point(i,j));
            }
        }


        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point tmp = Q.poll();
                for(int j=0; j<4; j++) {
                    int nx = tmp.x+dx[j];
                    int ny = tmp.y+dy[j];
                    if(nx>=0 && nx<m && ny>=0 && ny<n && box[nx][ny]==0) {
                        box[nx][ny]=1;
                        Q.offer(new Point(nx,ny));
                    }
                }
            }
            if(!Q.isEmpty()) answer++;
        }


        // 큐가 빌때까지, 여기 반복문 없어도 실행되지 않을까 싶음
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int j=0; j<4; j++) {
                int nx = tmp.x+dx[j];
                int ny = tmp.y+dy[j];

                // 모서리가 아니면서 0 인경우
                if(nx>=0 && nx<m && ny>=0 && ny<n && box[nx][ny]==0) {
                    box[nx][ny]=1;
                    Q.offer(new Point(nx,ny));
                }
            }
            if(!Q.isEmpty()) answer++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        box = new int[m][n];

        // 맵 초기화
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                box[i][j]= sc.nextInt();
            }
        }

        // bfs 실행
        bfs(n,m);

        boolean ch = true;
        // 0이 있는 경우 ch는 거짓
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(box[i][j]==0) {
                    ch = false;
                    break;
                }
            }
        }

        // 0이 하나라도 있으면 -1 반환
        System.out.print(ch ? answer : -1);
    }
}

// 좌표를 저장할 클래스
class Point {
    public int x, y;
    Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}