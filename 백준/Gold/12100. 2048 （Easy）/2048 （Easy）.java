import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, map);
        System.out.println(max);
    }

    static void dfs(int depth, int[][] mapNow){
        if(depth == 5){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    max = Math.max(max, mapNow[i][j]);
                }
            }
            return;
        }

        for(int d=0;d<4;d++){
            int[][] copiedMap = copyMap(mapNow); // 깊은 복사
            move(copiedMap, d);
            dfs(depth+1, copiedMap);
        }
    }

    static void move(int[][] mapNow, int direction){
        for(int i=0;i<N;i++){
            Deque<Integer> queue = new ArrayDeque<>();

            for(int j=0;j<N;j++){
                int value = 0;
                switch(direction){
                    case 0: value = mapNow[j][i]; break;       // 위
                    case 1: value = mapNow[N - 1 - j][i]; break; // 아래
                    case 2: value = mapNow[i][j]; break;       // 왼쪽
                    case 3: value = mapNow[i][N - 1 - j]; break; // 오른쪽
                }
                if(value != 0) queue.addLast(value);
            }

            List<Integer> merged = new ArrayList<>();
            while(!queue.isEmpty()){
                int curr = queue.pollFirst();
                if(!queue.isEmpty() && curr == queue.peekFirst()){
                    queue.pollFirst();
                    merged.add(curr * 2);
                } else {
                    merged.add(curr);
                }
            }

            while(merged.size() < N) merged.add(0); // 패딩

            for(int j=0;j<N;j++){
                int val = merged.get(j);
                switch(direction){
                    case 0: mapNow[j][i] = val; break;             // 위
                    case 1: mapNow[N - 1 - j][i] = val; break;     // 아래
                    case 2: mapNow[i][j] = val; break;             // 왼쪽
                    case 3: mapNow[i][N - 1 - j] = val; break;     // 오른쪽
                }
            }
        }
    }

    static int[][] copyMap(int[][] src){
        int[][] dest = new int[N][N];
        for(int i=0;i<N;i++){
            dest[i] = src[i].clone(); // 깊은 복사
        }
        return dest;
    }
}
