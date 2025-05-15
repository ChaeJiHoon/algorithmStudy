import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a =Integer.valueOf(br.readLine());
        int b =Integer.valueOf(br.readLine());

        System.out.println(a+b);
    }

}
