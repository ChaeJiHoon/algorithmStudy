import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[101][101];

        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            dragonCurve(startX,startY,dir,p);
        }

        int cnt = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++) if(visited[i][j]&&visited[i+1][j]&&visited[i][j+1]&&visited[i+1][j+1]) cnt++;
        }

        System.out.print(cnt);
    }

    static void dragonCurve(int x, int y, int dir, int p){
        // 명령 기억 리스트
        List<Integer> command = new ArrayList<>();
        command.add(dir);

        // 현재점에서 시작
        int[] now = {x,y};
        int nowDir = dir;
        visited[y][x] = true;

        while(p-->0){
            // 리스트 명령 모두 순회, 역순으로
            int len = command.size();

            for(int i=len-1;i>=0;i--){
                now = move(now[0],now[1],nowDir);
                nowDir = direction(command.get(i));
                command.add(nowDir);
                visited[now[1]][now[0]] = true;
            }

        }
        now = move(now[0],now[1],nowDir);
        visited[now[1]][now[0]] = true;

    }

    static int[] move(int x, int y, int dir){
        if(dir==0) return new int[]{x+1, y};
        else if(dir==1) return new int[]{x, y-1};
        else if(dir==2) return new int[]{x-1, y};
        else return new int[]{x, y+1};
    }

    static int direction(int dir){
        if(dir==0) return 1;
        else if(dir==1) return 2;
        else if(dir==2) return 3;
        else return 0;
    }

}
