import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int minAnswer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        func();
        System.out.println(minAnswer);
    }

    static void func(){
        for(int r=0;r<N-2;r++){
            for(int c=1;c<N-1;c++) dfs(1,new int[]{r,c},new int[]{});
        }
    }

    static void dfs(int depth, int[] ar1, int[] ar2){
        int nR = ar1[0];
        int nC = ar1[1];

        if(depth==1){
            while(++nR<N && --nC>=0){
                dfs(2,ar1,new int[]{nR,nC});
            }
        }else if(depth==2){
            int[] arr3 = new int[2];
            int[] arr4 = new int[2];

            arr3[0] = ar1[0];
            arr3[1] = ar1[1];
            arr4[0] = ar2[0];
            arr4[1] = ar2[1];

            // 좌표 내부임
            while((++arr3[0]<N && ++arr3[1]<N) && (++arr4[0]<N && ++arr4[1]<N)){
                divisionZone(ar1,ar2,arr3,arr4);
            }
        }
    }

    static void divisionZone(int[] ar1, int[] ar2, int[] ar3, int[] ar4){
        int[][] tempMap = new int[N][N];

        int lX = ar1[1];
        int rX = ar1[1];

        for(int r=ar1[0];r<=ar4[0];r++){
            for(int c=lX;c<=rX;c++) tempMap[r][c] = 5;

            if(r<ar2[0]) lX--;
            else lX++;

            if(r<ar3[0]) rX++;
            else rX--;
        }
        
        int[][] dir4 = { {-1,0},{1,0},{0,-1},{0,1} };
        
        Deque<int[]> q1 = new ArrayDeque<>();
        if (tempMap[0][0] != 5 && 0 < ar2[0] && 0 <= ar1[1]) {
            tempMap[0][0] = 1;
            q1.add(new int[]{0,0});
        }
        
        while (!q1.isEmpty()) {
            int[] cur = q1.poll();
            for (int[] d : dir4) {
                int nr = cur[0]+d[0];
                int nc = cur[1] + d[1];
                if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if (tempMap[nr][nc] != 0) continue;
                if (nr<ar2[0] && nc<=ar1[1]) {
                    tempMap[nr][nc] = 1;
                    q1.add(new int[]{nr,nc});
                }
            }
        }
        

        
        Deque<int[]> q2 = new ArrayDeque<>();
        if (tempMap[0][N-1] != 5 && 0 <= ar3[0] && (N-1) > ar1[1]) {
            tempMap[0][N-1] = 2;
            q2.add(new int[]{0,N-1});
        }
        while (!q2.isEmpty()) {
            int[] cur = q2.poll();
            for (int[] d : dir4) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if (tempMap[nr][nc] != 0) continue;
                if (nr <= ar3[0] && nc > ar1[1]) {
                    tempMap[nr][nc] = 2;
                    q2.add(new int[]{nr, nc});
                }
            }
        }
        
        Deque<int[]> q3 = new ArrayDeque<>();
        if (tempMap[N-1][0] != 5 && (N-1) >= ar2[0] && 0 < ar4[1]) {tempMap[N-1][0] = 3;
            q3.add(new int[]{N-1,0});
        }
        while (!q3.isEmpty()) {
            int[] cur = q3.poll();
            for (int[] d : dir4) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if (tempMap[nr][nc] != 0) continue;
                if (nr >= ar2[0] && nc < ar4[1]) {
                    tempMap[nr][nc] = 3;
                    q3.add(new int[]{nr,nc});
                }
            }
        }
        
        Deque<int[]> q4 = new ArrayDeque<>();
        if (tempMap[N-1][N-1] != 5 && (N-1) > ar3[0] && (N-1) >= ar4[1]) {
            tempMap[N-1][N-1] = 4;
            q4.add(new int[]{N-1,N-1});
        }
        while (!q4.isEmpty()) {
            int[] cur = q4.poll();
            for (int[] d : dir4) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if (tempMap[nr][nc] != 0) continue;
                if (nr > ar3[0] && nc >= ar4[1]) {
                    tempMap[nr][nc] = 4;
                    q4.add(new int[]{nr,nc});
                }
            }
        }
        
        calMinMax(tempMap);
    }

    static void calMinMax(int[][] a){
        int[] sum = new int[5];

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(a[r][c]==1) sum[0] += map[r][c];
                else if(a[r][c]==2) sum[1] += map[r][c];
                else if(a[r][c]==3) sum[2] += map[r][c];
                else if(a[r][c]==4) sum[3] += map[r][c];
                else sum[4] += map[r][c];
            }
        }

        Arrays.sort(sum);
        minAnswer = Math.min(minAnswer, (sum[4]-sum[0]));
    }

}
