import java.io.*;
import java.util.*;

public class Main {

    // 세로 선
    static boolean[][] widthLadder;

    static int N,M,H;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 5
        M = Integer.parseInt(st.nextToken());   // 5
        H = Integer.parseInt(st.nextToken());   // 6

        widthLadder = new boolean[H][N+1];      // 양 사이드는 버릴거임

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 점선 위치
            int b = Integer.parseInt(st.nextToken());   // b번 세로선과 b+1 세로선

            widthLadder[a-1][b] = true;
        }
        /*------------------여기까지 사다리 맵 완성-----------------------*/

        if(ladderGame()){
            System.out.println(0);
            return;
        }

        dfs(0, 0, 1);

        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }



    // ladder : 놓은 사다리 갯수
    // startRow, startCol: 이번 호출에서 "이 위치부터" 탐색 시작
    static void dfs(int ladder, int startRow, int startCol) {
        if(ladder>3) return;
        if(ladder>=min) return; // 이미 더 나쁨 경우 가지치기

        if(ladderGame()){
            min = Math.min(min,ladder);
            return;
        }

        // 사다리 추가 시도 (조합 탐색: 시작 위치 이후만)
        for (int i=startRow;i<H;i++){
            int jStart = (i == startRow ? startCol : 1);
            for(int j=jStart;j<N;j++) { // j는 1..N-1
                if (widthLadder[i][j] || widthLadder[i][j-1] || widthLadder[i][j+1]) continue;

                widthLadder[i][j] = true;
                dfs(ladder+1,i,j+2);  // 같은 행에서는 인접 오른쪽은 절대 못 놓으니 j+2부터 탐색
                widthLadder[i][j] = false;
            }
        }
    }


    // 사다리 게임 돌려서 실패와 성공 반환
    static boolean ladderGame(){
        // 세로 사다리 맨위에서 부터 하나씩 출발
        // 하나라도 다른 사다리로 도착하면 실패
        for(int i=0;i<N;i++){
            int now = i;
            for(int j=0;j<H;j++){
                // 사다리가 있는 경우, 옆으로 이동
                if(widthLadder[j][now+1]) {
                    now++;
                    continue;
                }
                if(widthLadder[j][now]) now--;
            }

            if(now!=i) return false;
        }
        return true;
    }
}
