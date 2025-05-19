package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessBord {
    static String[][] wBoard =
                   {{"W","B","W","B","W","B","W","B"},
                    {"B","W","B","W","B","W","B","W"},
                    {"W","B","W","B","W","B","W","B"},
                    {"B","W","B","W","B","W","B","W"},
                    {"W","B","W","B","W","B","W","B"},
                    {"B","W","B","W","B","W","B","W"},
                    {"W","B","W","B","W","B","W","B"},
                    {"B","W","B","W","B","W","B","W"}};

    static String[][] bBoard =
                   {{"B","W","B","W","B","W","B","W"},
                    {"W","B","W","B","W","B","W","B"},
                    {"B","W","B","W","B","W","B","W"},
                    {"W","B","W","B","W","B","W","B"},
                    {"B","W","B","W","B","W","B","W"},
                    {"W","B","W","B","W","B","W","B"},
                    {"B","W","B","W","B","W","B","W"},
                    {"W","B","W","B","W","B","W","B"}};

    static String[][] map;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        min = n*m;

        map = new String[n][m];

        for(int i=0;i<n;i++) {
            map[i] = br.readLine().split("");
        }

        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++){
                chess(i,j);
            }
        }

        System.out.println(min);
    }

    static void chess(int y, int x){
        int wc = 0;
        int bc = 0;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(map[y+i][x+j].equals(wBoard[i][j])) wc++;
                if(map[y+i][x+j].equals(bBoard[i][j])) bc++;
            }
        }
        if(wc<min) min = wc;
        if(bc<min) min = bc;
    }
}
