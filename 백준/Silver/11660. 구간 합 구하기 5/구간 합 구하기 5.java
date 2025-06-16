import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=0;j<N;j++){
                sum += map[i][j];
                if(i==0) map[i][j] = sum;
                else map[i][j] = sum+map[i-1][j];
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;

            if(x1==0&&y1==0){
                sb.append(map[y2][x2]).append("\n");
            }else if(x1==0){
                sb.append(map[y2][x2]-map[y1-1][x2]).append("\n");
            }else if(y1==0){
                sb.append(map[y2][x2]-map[y2][x1-1]).append("\n");
            }else{
                sb.append(map[y2][x2] - (map[y1-1][x2]+map[y2][x1-1]-map[y1-1][x1-1])).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
