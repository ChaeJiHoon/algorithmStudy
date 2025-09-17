import java.util.*;
import java.io.*;

public class Main {

    static int R,C,M;
    static int answer = 0;
    static List<Shark>[][] map;
    static List<int[]>[][] sharkList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[R+1][C+1];

        for(int i=0;i<=R;i++){
            for(int j=0;j<=C;j++) map[i][j] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            String line = br.readLine();
            st = new StringTokenizer(line);


            int sharkR = Integer.parseInt(st.nextToken());
            int sharkC = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            map[sharkR][sharkC].add(new Shark(speed,dir,size,false));
        }

        int fishingKing = 0;

        while(fishingKing<C){
            fishingKing++;

            // 상어 낚시
            for(int i=1;i<=R;i++){
                if(map[i][fishingKing].size()>0){     // 비어있지 않으면 낚시
                    answer += map[i][fishingKing].get(0).size;
                    map[i][fishingKing] = new ArrayList<>();
                    break;
                }
            }

            // 모든 상어 움직일 준비
            for(int i=1;i<=R;i++){
                for(int j=1;j<=C;j++) {
                    if(map[i][j].size()>0) map[i][j].get(0).trigger = false;
                }
            }

            
            for(int i=1;i<=R;i++){
                for(int j=1;j<=C;j++){
                    if(map[i][j].size()==0 || map[i][j].get(0).trigger) continue;
                    map[i][j].get(0).trigger = true;
                    sharkMove(i,j);
                }
            }

            // 가장 큰 상어만 냄기고 다 죽임
            for(int i=1;i<=R;i++){
                for(int j=1;j<=C;j++) {
                    if(map[i][j].size()>0){
                        Collections.sort(map[i][j]);
                        while(map[i][j].size()>1){
                            map[i][j].remove(1);
                        }
                    }
                }
            }

        }

        System.out.println(answer);
    }


    static void sharkMove(int r, int c){
        Shark now = map[r][c].remove(0);
        int cnt = now.speed;

        while(cnt>0){

            // 머리 방향 위로
            if(now.dir==1){
                int len = r-1;   // 가야하는 칸임
                if(cnt>len){  // 벽에 만난 경우
                    r = 1;
                    now.dir = 2;
                    cnt -= len;
                }else{
                    r -= cnt;
                    cnt = 0;
                }
            }else if(now.dir==2){  // 머리 방향 아래
                int len = R-r;
                if(cnt>len){  // 더 많이 가야한다는 소리임
                    r = R;
                    now.dir = 1;
                    cnt -= len;
                }else{
                    r += cnt;
                    cnt = 0;
                }
            }
            else if(now.dir==3){  // 머리 방향 ㅇ우측
                int len = C-c;
                if(cnt>len){  // 더 많이 가야한다는 소리임
                    c = C;
                    now.dir = 4;
                    cnt -= len;
                }else{
                    c += cnt;
                    cnt = 0;
                }
            } else {  // 머리 방향 좌측
                int len = c-1;
                if(cnt>len){  // 더 많이 가야한다는 소리임
                    c = 1;
                    now.dir = 3;
                    cnt -= len;
                }else{
                    c -= cnt;
                    cnt = 0;
                }
            }
        }

        map[r][c].add(now);
    }


    static class Shark implements Comparable<Shark>{
        int speed;
        int dir;
        int size;
        boolean trigger;

        Shark(int speed, int dir, int size, boolean trigger){
            this.speed = speed;
            this.dir = dir;
            this.size = size;
            this.trigger = trigger;
;        }

        @Override
        public int compareTo(Shark s){
            return s.size - this.size;
        }
    }
}
