import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr  = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);

        System.out.println(white);
        System.out.println(blue);

    }

    static void divide(int x, int y, int size){
        int firstColor = arr[y][x];
        boolean tf = true;

        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(firstColor != arr[i][j]) {
                    tf = false;
                    break;
                }
            }
        }

        int nSize = size/2;
        if(tf){
            if(firstColor==1) blue++;
            else white++;
        }else{
            divide(x,y,nSize);
            divide(x+nSize,y,nSize);
            divide(x,y+nSize,nSize);
            divide(x+nSize,y+nSize,nSize);
        }

    }
}
