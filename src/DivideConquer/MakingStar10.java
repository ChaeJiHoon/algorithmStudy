package DivideConquer;
// 백준 | 분할정복 | 골드 5
// 2447 번 : 색종이 만들기
// 시간 제한 : 1초, 메모리 제한 : 256 MB
// 25.06.05
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakingStar10 {
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
