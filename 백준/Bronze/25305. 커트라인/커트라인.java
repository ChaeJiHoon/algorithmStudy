import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Integer[] arr = new Integer[N];

        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        System.out.print(arr[N-k]);
    }
}