import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            arr[i] = num;
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for(int i=0;i<list.size();i++) map.put(list.get(i),i);
        for(int i=0;i<N;i++) sb.append(map.get(arr[i])).append(" ");

        System.out.print(sb.toString().trim());
    }
}
