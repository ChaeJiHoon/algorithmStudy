package bfs;
// 백준 | BFS,브루트포스,구현| 골드 4
// 14502 번 : 계단 오르기
// 시간 제한 : 2초, 메모리 제한 : 512 MB
// 25.06.10

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ResearchInstituteRefactoring {
    static int[][] originMap;
    static List<int[]> list = new LinkedList<>();
    static List<int[]> virusList = new LinkedList<>();

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int N;
    static int M;
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originMap = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                originMap[i][j] = num;

                // 0 리스트
                if(num==0) list.add(new int[]{i,j});

                // 2 리스트
                if(num==2) virusList.add(new int[]{i, j});

            }
        }

        // 부르트포스 탐색
        for(int i=0;i<list.size()-2;i++){
            for(int j=i+1;j<list.size()-1;j++){
                for(int k=j+1;k<list.size();k++){

                    // 새 맵 만들고
                    int[][] map = newMap();

                    // 무작위 3개 벽 1로 만듬
                    map[list.get(i)[0]][list.get(i)[1]] = 1;
                    map[list.get(j)[0]][list.get(j)[1]] = 1;
                    map[list.get(k)[0]][list.get(k)[1]] = 1;

                    // 바이러스 퍼트림
                    spreadVirua(map);

                    // 빈영역 셈
                    countSafeArea(map);

                }
            }
        }
        System.out.println(max);
    }

    // 바이러스 bfs, 2로 감염시킴
    static void spreadVirua(int[][] map){
        Queue<int[]> q = new LinkedList<>(virusList);

        while(!q.isEmpty()){
            int[] narr = q.poll();
            int x = narr[1], y=narr[0];
            map[y][x] = 2;

            for(int i=0;i<4;i++){
                int newx = x+dx[i];
                int newy = y+dy[i];
                if(newx>=0 && newy>=0 && newx<M && newy<N && map[newy][newx]==0){
                    q.add(new int[]{newy,newx});
                }
            }
        }

    }

    // 맵 초기화 함수
    static int[][] newMap(){
        int[][] nMap = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                nMap[i][j] = originMap[i][j];
            }
        }
        return nMap;
    }

    // 안전 영역 확인 함수
    static void countSafeArea(int[][] map){
        cnt=0;
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                if(map[a][b]==0) cnt++;
            }
        }
        max = Math.max(max,cnt);
    }

}

/*
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
 */