import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int R,T,C;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<int[]> aP = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];

        for(int i=1;i<=R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=C;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1) aP.add(new int[]{i,j});
            }
        }

        while(T-->0){
            bfs();
            dustMove(aP.get(0), aP.get(1));
/*
            System.out.println("청정기");
            for(int i=1;i<=R;i++){
                for(int j=1;j<=C;j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();*/
        }

        int answer = 0;
        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++) if(map[i][j]!=-1) answer += map[i][j];
        }

        System.out.println(answer);
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> dustQ = new LinkedList<>();
        visited = new boolean[R+1][C+1];

        q.add(new int[]{R,C});

        while(!q.isEmpty()){

            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nY = cur[0]+dy[i];
                int nX = cur[1]+dx[i];

                if(nY<=0||nX<=0||nY>R||nX>C||map[nY][nX]==-1||visited[nY][nX]) continue;
                int[] ne = {nY,nX};
                q.add(ne);
                visited[nY][nX] = true;
                if(map[nY][nX]>0) dustQ.add(ne);
            }
        }

        dustSpread(dustQ);
    }

    static void dustSpread(Queue<int[]> dustQ){
        int[][] temp = new int[R+1][C+1];

        // 먼지 큐 돌리기
        while(!dustQ.isEmpty()){

            int[] cur = dustQ.poll();

            int curDust = map[cur[0]][cur[1]];        // 기존 먼지
            int divDust = map[cur[0]][cur[1]]/5;    // 나눠주는 먼지
            int cnt = 0;    // 얼마나 나눠주는지 카운트

            for(int i=0;i<4;i++){
                int nY = cur[0]+dy[i];
                int nX = cur[1]+dx[i];

                if(nY<=0||nX<=0||nY>R||nX>C||map[nY][nX]==-1) continue;
                cnt++;
            }

            curDust -= cnt*divDust;                // 먼지 빼고

            for(int i=0;i<4;i++){
                int nY = cur[0]+dy[i];
                int nX = cur[1]+dx[i];

                if(nY<=0||nX<=0||nY>R||nX>C||map[nY][nX]==-1) continue;
                temp[nY][nX] += divDust;            // 먼지 확산
            }

            temp[cur[0]][cur[1]] += curDust;
        }

        // 임시 배열에 있던 것
        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++) map[i][j] = temp[i][j];
        }

        for(int i=0;i<2;i++) map[aP.get(i)[0]][aP.get(i)[1]] = -1;

    }

    static void dustMove(int[] start1, int[] start2){
        int[][] temp = new int[R+1][C+1];
        boolean[][] visited = new boolean[R+1][C+1];

        int Y = start1[0];
        int X = start1[1]+1;
        visited[Y][X] = true;

        while(map[Y][X]!=-1){
            int preY = Y;
            int preX = X;

            if(X==1) Y++;
            else if(Y==1) X--;
            else if(X==C) Y--;
            else X++;

            if(map[Y][X]==-1) break;
            visited[Y][X] = true;
            temp[Y][X] = map[preY][preX];
        }

        Y = start2[0];
        X = start2[1]+1;
        visited[Y][X] = true;

        while(map[Y][X]!=-1){
            int preY = Y;
            int preX = X;

            if(X==1) Y--;
            else if(Y==R) X--;
            else if(X==C) Y++;
            else X++;

            if(map[Y][X]==-1) break;

            visited[Y][X] = true;
            temp[Y][X] = map[preY][preX];
        }

        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++) if(!visited[i][j]) temp[i][j] = map[i][j];
        }

        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++) if(visited[i][j]) map[i][j] = temp[i][j];
        }


    }


}
