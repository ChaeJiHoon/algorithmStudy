import java.util.*;
import java.io.*;

public class Main {

    static String[][] map;
    static HashMap<Integer,String> play = new HashMap<>();
    static Queue<Integer> q = new LinkedList<>();
    static int N,K,L;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N+1][N+1];

        for(int i=0;i<=N;i++)Arrays.fill(map[i],"O");

        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = "A";
        }

        L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            play.put(n,str);
            q.add(n);
        }

        System.out.println(func());

    }

    static int func(){
        Queue<int[]> tail = new LinkedList<>();
        // 방향 변수, 4으로 나눈 나머지로 결정한다, 0-우, 1-하, 2-좌, 3-상
        int dir = 100;
        int headX = 1;
        int headY = 1;
        int playTime = 0;
        map[1][1] = "S";


        int index = 0;              // 반복문에서 토큰을 다쓴 경우, 다음 play로 넘어가기 위한 변수
        while(true){
            int token = q.isEmpty() ? 100 : q.poll();
            String nextDire = play.get(token);          // 머리 방향 변수

            int nowDirection = dir%4;                       // 현재 방향
            int nx=0, ny=0;

            token -= playTime;
            for(int i=token;i>0;i--){

                playTime++;

                // 일단 꼬리 큐에 머리는 무조건 집어넣음
                tail.add(new int[]{headX,headY});

                if(nowDirection==0){
                    nx = headX+1;
                    ny = headY;
                }else if(nowDirection==1){
                    nx = headX;
                    ny = headY+1;
                }
                else if(nowDirection==2){
                    nx = headX-1;
                    ny = headY;
                }else if(nowDirection==3){
                    nx = headX;
                    ny = headY-1;
                }

                // 벽에 부딪히거나, 몸통을 만나면 종료
                if(nx<=0 || ny<=0 || nx>N || ny>N || map[ny][nx].equals("S")) return playTime;

                // 사과를 못 먹으면 그냥 꼬리 지움
                if(map[ny][nx].equals("A")) map[ny][nx] = "S";
                else{
                    int[] deleteTail = tail.poll();
                    map[deleteTail[1]][deleteTail[0]] = "O";
                    map[ny][nx] = "S";
                }

                // 새로운 머리
                headX = nx;
                headY = ny;
            }

            // 방향 정하기
            dir += direction(nextDire);

        }
    }

    // 머리 방향을 정하는 함수
    static int direction(String dir){
        if(dir.equals("D")) return 1;
        else return -1;
    }

}