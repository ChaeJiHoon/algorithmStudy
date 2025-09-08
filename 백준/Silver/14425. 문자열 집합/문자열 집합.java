import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) set.add(br.readLine());

        int cnt = 0;

        for (int i=0;i<M;i++) if(set.contains(br.readLine())) cnt++;

        System.out.println(cnt);
    }

}
