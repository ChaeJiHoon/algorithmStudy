import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr =
                {{12,1600},{11,894},{11,1327},{10,1311},
                {9,1004},{9,1178},{9,1357},{8,837},{7,1055}, {6,556}, {6,773}};

        int m = Integer.parseInt(br.readLine());
        System.out.println(arr[m-1][0] + " " +arr[m-1][1]);
    }
}
