import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[][] word = new String[5][15];

        for(int i=0;i<5;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<str.length;j++) word[i][j] = str[j];
        }

        for(int i=0;i<15;i++){
            for(int j=0;j<5;j++) {
                if(word[j][i]==null)continue;
                sb.append(word[j][i]);
            }
        }

        System.out.print(sb.toString());
    }
}
