import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         long S = Long.parseLong(br.readLine());

        long N = 1;
        while(true){
            if(S-N>0) S -= N++;
            else if(S-N==0) break;
            else {
                N--;
                break;
            }
        }

        System.out.println(N);
    }

}
