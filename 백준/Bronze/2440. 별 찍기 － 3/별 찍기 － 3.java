import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());
        for(int i=0;i<X;i++){
            for(int j=X-i-1;j>=0;j--) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }

}