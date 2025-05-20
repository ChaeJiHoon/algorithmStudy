import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] strArr = br.readLine().split("");

        for(int i=0;i<strArr.length;i++) {
            int n = strArr[i].charAt(0);
            if (n > 96) strArr[i] = strArr[i].toUpperCase();
            else strArr[i] = strArr[i].toLowerCase();
        }

        for (String s : strArr) {
            sb.append(s);
        }

        System.out.println(sb.toString());

    }
}
