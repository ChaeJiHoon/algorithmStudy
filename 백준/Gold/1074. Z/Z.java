import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int r, c, result=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = 1<<N;
        painting(0,0,size);
        System.out.println(result);

    }

    static void painting(int row, int col, int size){
        if(size==1) return;

        int newSize = size/2;
        int area = newSize*newSize;

        if(r<row+newSize && c<col+newSize) painting(row,col,newSize);
        else if(r<row+newSize && c>=col+newSize){
            result += area;
            painting(row, col+newSize, newSize);
        }else if(r>=row+newSize && c<col+newSize){
            result += area*2;
            painting(row+newSize, col, newSize);
        }else if(r>=row+newSize && c>=col+newSize){
            result += area*3;
            painting(row+newSize, col+newSize, newSize);
        }
    }
}
