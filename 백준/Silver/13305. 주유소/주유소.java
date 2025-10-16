import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Long> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++) list.add(Long.parseLong(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        sum += list.get(0)*m;

        for(int i=1;i<list.size();i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp<m) m = temp;
            sum += list.get(i)*m;
        }

        System.out.println(sum);
    }
}