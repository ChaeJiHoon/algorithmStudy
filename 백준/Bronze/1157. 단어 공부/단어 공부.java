import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] arr = new int[26];

        for(int i=0;i<str.length();i++) arr[str.charAt(i)-'A']++;

        int max = 0;
        char alp = 0;
        for(int i=0;i<26;i++){
            if(max<arr[i]) {
                max = arr[i];
                alp = (char)((char)i + 'A');
            }
        }
        int cnt = 0;
        for(int i=0;i<26;i++) if(max==arr[i]) cnt++;

        if(cnt > 1)System.out.println("?");
        else System.out.println(alp);
    }
}
