import java.util.*;
import java.io.*;

public class Main {

    static int[][] sudoku = new int[9][9];
    static List<int[]> blank = new ArrayList<>();
    static boolean isFinished = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            String str = br.readLine();
            for(int j=0;j<9;j++){
                sudoku[i][j] = str.charAt(j)-'0';
                if(sudoku[i][j] == 0) blank.add(new int[]{i,j});
            }
        }

        dfs(0);
    }

    static void dfs(int depth) {
        if(isFinished) return;
        
        if(depth == blank.size()){
            printSudoku();
            isFinished = true;
            return;
        }

        int[] now = blank.get(depth);
        int x = now[0];
        int y = now[1];

        for(int num=1;num<=9;num++){
            if(isPossible(x, y, num)) {
                sudoku[x][y] = num;
                dfs(depth + 1);
                sudoku[x][y] = 0; // 백트래킹
            }
        }
    }

    static boolean isPossible(int x, int y, int value){
        for(int i=0;i<9;i++){
            if(sudoku[x][i] == value || sudoku[i][y] == value) return false;
        }

        int startX = (x/3)*3;
        int startY = (y/3)*3;

        for(int i=startX;i<startX+3;i++){
            for(int j=startY;j<startY+3;j++){
                if(sudoku[i][j]==value) return false;
            }
        }

        return true;
    }

    static void printSudoku(){
        StringBuilder sb = new StringBuilder();
        for(int[] row : sudoku){
            for(int value : row){
                sb.append(value);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }


}