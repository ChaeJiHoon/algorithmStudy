import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N==1) bw.write(1 % 15746 + "\n");
        else if (N==2) bw.write(2 % 15746 + "\n");
        else{
            int a=1, b=2, num=0;
            for (int i=2; i<N;i++) {
                num = (a+b) % 15746;
                a = b;
                b = num;
            }
            bw.write(num +"");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
