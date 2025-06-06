package bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bfsClassic {
    static int n;
    static boolean[][] visited;
    static String[][] map;
    static List<Integer> list = new ArrayList<>();

    static int cnt = 1;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        map = new String[n][n];

        for(int i=0;i<n;i++) map[i] = br.readLine().split(" ");

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && map[i][j].equals("1")){
                    bfs(j,i);
                    if(cnt != 0){
                        list.add(cnt);
                        cnt = 1;
                    }
                }
            }
        }

        int listStze = list.size();

        Collections.sort(list);

        for(int i=0;i<listStze;i++){
            sb.append(list.remove(0)).append(" ");
        }

        System.out.println(listStze);
        System.out.println(sb.toString().trim());

    }

    static void bfs(int x, int y){
        if(visited[y][x]) return;
        visited[y][x] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<n && map[ny][nx].equals("1") && !visited[ny][nx]){
                cnt++;
                bfs(nx,ny);
            }
        }

    }
}

/*
0 1 1 0 1 1
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 0 1
0 1 1 0 0 0
0 1 1 1 0 0
*/
