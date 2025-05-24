import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            list.add(br.readLine());
        }
        Collections.sort(list);

        for(int i=0;i<m;i++){
            set.add(br.readLine());
        }
        int length = list.size();

        for(int i=0;i<length;i++){
            String str = list.get(0);
            if(set.contains(str)){
                count++;
                sb.append(str).append("\n");
            }
            list.remove(0);
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
