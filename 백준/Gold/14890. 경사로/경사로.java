import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N, L;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 2*N;
        visited = new boolean[N][N];
        // 가로 윗줄 순회, y길 확인
        for(int i=0;i<N;i++){
            int now = map[0][i];    // 시작점
            for(int j=1;j<N;j++){   // 다음칸 확인
                int next = map[j][i];
                if(now<next){       // 다음칸이 더 높은 경우
                    if(Math.abs(now-next)>1){
                        answer--;    // 경사로를 못 놓으면
                        break;
                    }
                    if(!yCheck1(i,j-1)){
                        answer--;    // 경사로를 못 놓으면
                        break;
                    }
                }else if(now>next){    // 다음칸이 더 낮은 경우
                    if(Math.abs(now-next)>1){
                        answer--;    // 경사로를 못 놓으면
                        break;
                    }
                    if(!yCheck2(i,j)){   // 다음 칸을 넘겨줌
                        answer--;    // 경사로를 못 놓으면
                        break;
                    }
                }
                now = next;
            }
        }

        visited = new boolean[N][N];
        // 세로줄 순회, x길 확인
        for(int i=0;i<N;i++){
            int now = map[i][0];    // 시작점
            for(int j=1;j<N;j++){   // 다음칸 확인
                int next = map[i][j];
                if(now<next){       // 다음칸이 더 높은 경우
                    if(Math.abs(now-next)>1){
                        answer--;    // 경사로를 못 놓으면
                        break;
                    }
                    if(!xCheck1(i,j-1)){
                        answer--;    // 경사로를 못 놓으면
                        break;
                    }
                }else if(now>next){    // 다음칸이 더 낮은 경우
                    if(Math.abs(now-next)>1){
                        answer--;    // 경사로를 못 놓으면
                        break;
                    }
                    if(!xCheck2(i,j)){   // 다음 칸을 넘겨줌
                        answer--;    // 경사로를 못 놓으면
                        break;
                    }
                }
                now = next;
            }
        }

        System.out.println(answer);
    }

    // 세로 확인, 다음칸이 더 높은 경우
    static boolean yCheck1(int x, int nowY){
        if(nowY-L+1<0) return false;    // 모서리를 넘는 경우
        for(int i=nowY;i>nowY-L;i--) {
            if(map[nowY][x]!=map[i][x]) return false;  // 길중 높이가 다른게 있는 경우
            if(visited[i][x]) return false;             // 경사로가 있는 경우
        }

        for(int i=nowY;i>nowY-L;i--) visited[i][x] = true;                      // 경사로를 놓을수 있는 경우, 방문 체크
        return true;
    }

    // 세로 확인, 다음칸이 더 낮은 경우, 다음칸을 넘겨 받음
    static boolean yCheck2(int x, int nowY){
        if(nowY+L>N) return false;    // 모서리를 넘는 경우
        for(int i=nowY;i<nowY+L;i++) {
            if(map[nowY][x]!=map[i][x]) return false;  // 길중 높이가 다른게 있는 경우
            if(visited[i][x]) return false;             // 경사로가 있는 경우
        }
        for(int i=nowY;i<nowY+L;i++) visited[i][x] = true;                      // 경사로를 놓을수 있는 경우, 방문 체크
        return true;
    }

    // 가로 확인, 다음칸이 더 높은 경우
    static boolean xCheck1(int y, int nowX){
        if(nowX-L+1<0) return false;    // 모서리를 넘는 경우
        for(int i=nowX;i>nowX-L;i--) {
            if(map[y][nowX]!=map[y][i]) return false;  // 길중 높이가 다른게 있는 경우
            if(visited[y][i]) return false;             // 경사로가 있는 경우
        }

        for(int i=nowX;i>nowX-L;i--) visited[y][i] = true;                      // 경사로를 놓을수 있는 경우, 방문 체크
        return true;
    }

    // 세로 확인 4, 다음칸이 더 낮은 경우, 다음칸을 넘겨 받음
    static boolean xCheck2(int y, int nowX){
        if(nowX+L>N) return false;    // 모서리를 넘는 경우
        for(int i=nowX;i<nowX+L;i++) {
            if(map[y][nowX]!=map[y][i]) return false;  // 길중 높이가 다른게 있는 경우
            if(visited[y][i]) return false;             // 경사로가 있는 경우
        }
        for(int i=nowX;i<nowX+L;i++) visited[y][i] = true;                      // 경사로를 놓을수 있는 경우, 방문 체크
        return true;
    }
}
