import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while(true){
            String str = br.readLine().toLowerCase();
            if(str.equals("#")) break;
            int cnt = 0;

            for(int i=0;i<str.length();i++) {
                char c = str.charAt(i);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') cnt++;
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}