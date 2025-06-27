import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String,Integer> wear = new HashMap<>();

            for(int i=0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothes = st.nextToken();
                String type = st.nextToken();
                wear.put(type, wear.getOrDefault(type,0)+1);
            }

            List<String> list = new ArrayList<>(wear.keySet());

            int answer = 1;

            for(String s : list) {
                int num = wear.get(s);
                answer *= num+1;
            }

            sb.append(answer-1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
