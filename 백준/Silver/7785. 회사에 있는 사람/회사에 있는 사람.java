import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            String[] str = br.readLine().split(" ");

            if(str[1].equals("enter")) set.add(str[0]);
            else set.remove(str[0]);
        }

        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        for(String s : list) sb.append(s).append("\n");
        System.out.println(sb);
    }
}