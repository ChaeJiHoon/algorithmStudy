import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int[][] map;
    // 이 리스트 순서대로 계속 실행할거임
    static ArrayList<Pieces> order = new ArrayList<>();
    static ArrayList<Pieces>[][] sequence;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        sequence = new ArrayList[N+1][N+1];

        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++) sequence[i][j] = new ArrayList<>();       // 여기서 리스트 확인하고, 위에 있는 경우 다 데리고 감
        }

        // 1 빨간색, 2 파란색
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 순서대로 저장, 여기서 1번부터 꺼내서 쓸거임
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            Pieces nP = new Pieces(new int[]{r,c}, dir, i);
            order.add(nP);
            sequence[r][c].add(nP);
        }

        int time = 0;
        while (true) {
            time++;

            if(!move()) {
                System.out.println(time);
                return;
            }

            if(time==1000) {
                System.out.println(-1);
                return;
            }
        }

    }

    static boolean move(){
        for(int i=0;i<order.size();i++){
            Pieces cur = order.get(i);

            // 현재 칸에서 스택 내 위치(se) 찾기
            int se = 0;
            ArrayList<Pieces> here = sequence[cur.location[0]][cur.location[1]];

            for(int k=0;k<here.size();k++){
                if(here.get(k).seq == i) {
                    se = k;
                    break;
                }
            }

            // 전진 좌표
            int[] newRC = direction(cur.location, cur.direction);

            // 먼저 out/blue 검사
            if(isOut(newRC[0],newRC[1]) || map[newRC[0]][newRC[1]]==2){
                // 방향 반전
                cur.direction = reverse(cur.direction);
                newRC = direction(cur.location, cur.direction);

                // 반전 후에도 out/blue면 이동하지 않음
                if(isOut(newRC[0], newRC[1]) || map[newRC[0]][newRC[1]]==2){
                    continue;    // ← 중요: 즉시 다음 말로
                }
            }

            int color = map[newRC[0]][newRC[1]];

            // ★ 소스/목적지 고정 참조 확보
            int sr = cur.location[0];
            int sc = cur.location[1];
            ArrayList<Pieces> src = sequence[sr][sc];
            ArrayList<Pieces> dst = sequence[newRC[0]][newRC[1]];

            if (color == 0) {
                while (src.size()>se){
                    Pieces mov = src.remove(se);

                    mov.location[0] = newRC[0];
                    mov.location[1] = newRC[1];
                    dst.add(mov);
                }
            } else {
                while (src.size() > se) {
                    Pieces mov = src.remove(src.size() -1);
                    mov.location[0] = newRC[0];
                    mov.location[1] = newRC[1];
                    dst.add(mov);
                }
            }

            if (dst.size()>=4) return false;

        }
        return true;
    }

    static boolean isOut(int r, int c){return r<1 || c<1 || r>N || c>N;}

    static int reverse(int d){
        if(d==1) return 2;
        else if(d==2) return 1;
        else if(d==3) return 4;
        else return 3;
    }

    static int[] direction(int[] rc, int d){
        if(d==1) return new int[]{rc[0],rc[1]+1};
        else if(d==2) return new int[]{rc[0],rc[1]-1};
        else if(d==3) return new int[]{rc[0]-1,rc[1]};
        else return new int[]{rc[0]+1,rc[1]};
    }

    static class Pieces{
        int[] location;
        int direction;
        int seq;        // 호출 순서

        Pieces(int[] location, int direction, int seq){
            this.location = location;
            this.direction = direction;
            this.seq = seq;
        }

    }
}

