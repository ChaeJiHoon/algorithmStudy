import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[][] map = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            for(int i=startY;i<startY+10;i++){
                for(int j=startX;j<startX+10;j++) if(!map[i][j]) map[i][j] = true;
            }
        }

        int cnt = 0;

        for(int i=1;i<=100;i++){
            for(int j=1;j<=100;j++) if(map[i][j]) cnt++;
        }

        System.out.print(cnt);
    }
}
