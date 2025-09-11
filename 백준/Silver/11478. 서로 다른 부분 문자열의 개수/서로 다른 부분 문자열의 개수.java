import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        HashSet<String> set = new HashSet<>();

        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++) set.add(s.substring(i,j));
        }

        System.out.println(set.size());
    }
}
