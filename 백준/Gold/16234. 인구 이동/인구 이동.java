import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N,L,R;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean trigger = true;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        while(trigger){
            cnt++;
            visited = new boolean[N][N];
            trigger = false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++) if(!visited[i][j]) bfs(j,i);
            }

        }

        System.out.print(--cnt);

    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();

        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nX = cur[0]+dx[i];
                int nY = cur[1]+dy[i];

                if(nX<0 || nY<0 || nX>=N || nY>=N || visited[nY][nX]) continue;

                int max = Math.max(map[cur[1]][cur[0]],map[nY][nX]);
                int min = Math.min(map[cur[1]][cur[0]],map[nY][nX]);
                //System.out.println("L의 값 : " + L+", R의 값 : " + R+", 차이: "+(max-min));
                if(L<=max-min && max-min<=R) {
                    visited[nY][nX] = true;
                    list.add(new int[]{nX, nY}); // 차이 계산 후, 리스트에 집어 넣음
                    q.add(new int[]{nX,nY});  // 열린 경우만 더 탐색함
                }
            }
        }

        // list가 0이면 인구 이동이 없는것임
        // 트리거 발동 X
        if(!list.isEmpty()){
            trigger = true;
            func(list);
        }

    }

    static void func(List<int[]> list){
        int sum = 0;

        for(int[] arr: list) sum += map[arr[1]][arr[0]];
        int ave = sum/list.size();

        for(int[] arr: list) map[arr[1]][arr[0]] = ave;
    }
}