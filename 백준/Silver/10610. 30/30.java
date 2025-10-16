import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] sArr = br.readLine().split("");
        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        boolean zero = false;
        for(int i=0;i<sArr.length;i++){
            int a = Integer.parseInt(sArr[i]);

            if(a==0 && !zero) zero = true;
            else sum += a;
            list.add(a);
        }
        if(!zero || sum%3!=0){System.out.println(-1);return;}
        list.sort(Collections.reverseOrder());

        for(int i : list) sb.append(i);

        System.out.println(sb);
    }
}