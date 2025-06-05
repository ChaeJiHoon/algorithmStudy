import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        map = new String[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = " ";
            }
        }

        makingStar(0,0,n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void makingStar(int row, int col, int n){
        if(n==3){
            for(int i=row;i<row+3;i++){
                for(int j=col;j<col+3;j++){
                    if(i==row+1 && j==col+1) continue;
                    else map[i][j] = "*";
                }
            }

        }else{
            int newN = n/3;
            makingStar(row,col,newN);
            makingStar(row,col+newN,newN);
            makingStar(row,col+newN*2,newN);

            makingStar(row+newN,col,newN);
            makingStar(row+newN,col+newN*2,newN);

            makingStar(row+newN*2,col,newN);
            makingStar(row+newN*2,col+newN,newN);
            makingStar(row+newN*2,col+newN*2,newN);
        }
    }
}
