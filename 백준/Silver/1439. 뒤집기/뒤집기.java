import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int one = 0;
        int zero = 0;
        
        if(s.charAt(0)=='1') one++;
        else zero++;


        for(int i=1;i<s.length();i++){
            if(s.charAt(i) != s.charAt(i-1)){
                if(s.charAt(i)=='1') one++;
                else zero++;
            }
        }

        System.out.println(Math.min(one, zero));
    }
}
