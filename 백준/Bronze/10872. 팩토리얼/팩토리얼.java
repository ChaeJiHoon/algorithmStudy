import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n==0) System.out.println(1);
        else {
            int num = 1;
            for(int i=1;i<=n;i++){
                num *= i;
            }

            System.out.println(num);
        }

    }
}
