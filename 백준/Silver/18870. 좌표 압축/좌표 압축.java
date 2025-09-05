import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            answer[i] = num;
        }

        Arrays.sort(arr);

        int index = 0;
        for(int i=0;i<N;i++){
            if (!map.containsKey(arr[i])) map.put(arr[i],index++);
        }

        for(int i=0;i<N;i++) sb.append(map.get(answer[i])).append(" ");

        System.out.print(sb.toString().trim());
    }
}
