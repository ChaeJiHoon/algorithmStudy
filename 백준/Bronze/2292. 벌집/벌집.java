import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int layer = 1;
        long range = 1;

        while(n > range) {
            range += 6 * layer;
            layer++;
        }

        System.out.println(layer);
    }
}
