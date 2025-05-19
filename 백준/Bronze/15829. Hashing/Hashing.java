import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int answer =0;

        for(int i=0;i<n;i++){
            int num = 1;
            for(int j=0;j<i;j++){
                num *= 31;
            }
            answer += num*(str.charAt(i)-96);
        }
        System.out.println(answer);
    }
}
