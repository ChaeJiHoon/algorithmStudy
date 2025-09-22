import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int a = 0;

        while(a+10<str.length()){
            sb.append(str.substring(a,a+10)).append("\n");
            a += 10;
        }
        sb.append(str.substring(a,str.length()));

        System.out.println(sb.toString());
    }
}