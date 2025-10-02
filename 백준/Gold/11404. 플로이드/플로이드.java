import java.util.*;
import java.io.*;

public class Main {

    static final long INF = Integer.MAX_VALUE;
    static int N, M;
    static long[][] dist;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new long[N+1][N+1];

        for(int i=0;i<=N;i++){
            Arrays.fill(dist[i],INF);
            dist[i][i] = 0;
        }

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(cost < dist[from][to]) dist[from][to] = cost;
        }
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(dist[j][i]==INF) continue;
                for(int k=1;k<=N;k++){
                    if(dist[i][k]==INF) continue;
                    long c = dist[j][i] + dist[i][k];
                    if(c<dist[j][k]) dist[j][k] = c;
                }
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(dist[i][j]==INF) sb.append(0).append(" ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}