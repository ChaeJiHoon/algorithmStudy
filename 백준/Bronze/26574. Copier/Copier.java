import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            int a = Integer.parseInt(br.readLine());
            sb.append(a).append(" ").append(a).append("\n");
        }
        System.out.println(sb.toString());
    }
}
