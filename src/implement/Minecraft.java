package implement;
// 백준 | 구현 | 실버 2
// 18111 번 : 마인크래프트
// 시간 제한 : 1초, 메모리 제한 : 1024 MB
// 25.06.10

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minecraft {
    static int[][] map;
    static int[] dp = new int[257];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<=256;k++){
            int time = 0;
            int inven = B;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int abs = Math.abs(k-map[i][j]);
                    if(k>map[i][j]) {               // dp가 맵보다 높으면 맵을 높여야함
                        if(inven>=abs){
                            time += abs;        // 시간 더하고, 얹는건 1초, 인벤이 가능한 경우
                            inven -= abs;
                        }
                        else {                  // 인벤에 블록이 부족한 경우
                            time += abs*2;    // 시간 더하고, 깎는건 2초
                            inven += abs;
                        }
                    }else if(k<map[i][j]){          // dp가 맵보다 낮으면 맵을 깎아야함
                        time += abs*2;    // 시간 더하고, 깎는건 2초
                        inven -= abs;
                    }
                }

            }
            dp[k] = time;
        }

        int minTime = dp[0];
        int height = 0;

        for(int i=1;i<=256;i++){
            System.out.println(dp[i]);
            if(dp[i]<minTime) minTime = dp[i];
            if(minTime==dp[i]) height = i;
        }


        System.out.println(height+" "+minTime);


    }
}
