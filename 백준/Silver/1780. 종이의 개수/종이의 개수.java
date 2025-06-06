import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] map;
    static int zero = 0;
    static int one = 0;
    static int mOne = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);

        System.out.println(mOne);
        System.out.println(zero);
        System.out.println(one);

    }

    static void divide(int row, int col, int size){
        if(isSame(row, col, size)){
            int num = map[row][col];
            if(num==-1) mOne++;
            else if(num==0) zero++;
            else one++;
            return;
        }

        int newSize = size/3;

        for(int i=row;i<row+size;i = i+newSize){
            for(int j=col;j<col+size;j = j+newSize){
                divide(i,j,newSize);
            }
        }

    }

    static boolean isSame(int row, int col, int size){
        int val = map[row][col];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
               if(map[i][j]!=val) return false;
            }
        }

        return true;
    }

}