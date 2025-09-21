import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int num = Integer.parseInt(br.readLine());
            int Q = 0;
            int D = 0;
            int N = 0;
            int P = 0;

            while(num>0){
                if(num>=25){
                    Q++;
                    num -= 25;
                }else if(num>=10){
                    D++;
                    num -= 10;
                }else if(num>=5){
                    N++;
                    num -= 5;
                }else{
                    P++;
                    num--;
                }
            }

            sb.append(Q+" ").append(D+" ").append(N+" ").append(P+" ").append("\n");
        }

        System.out.println(sb.toString());
    }


}
