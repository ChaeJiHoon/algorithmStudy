package tree;
// 백준 | 트리 | 실버 1
// 1991 번 : 트리 순회
// 시간 제한 : 2초, 메모리 제한 : 128 MB
// 25.06.07
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiameterOfTree {
    static String[][] map;
    static int N;

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N+1][N*2];

        mapping(0,N-1,N);

        for(int i=0;i<N;i++){
            for(int j=0;j<N*2;j++) {
                if(map[i][j]==null) sb.append(" ");
                else sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    static void mapping(int row, int col, int size){

        if(size==3){
            map[row][col] = "*";
            map[row+1][col+1] = "*";
            map[row+1][col-1] = "*";
            for(int i=col-2;i<col+3;i++) map[row+2][i]="*";
        }else{
            int cut = size/2;
            mapping(row,col,cut);
            mapping(row+cut,col-cut,cut);
            mapping(row+cut,col+cut,cut);
        }


    }
}
