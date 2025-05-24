import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> reversMap = new HashMap<>();

        StringTokenizer stt = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stt.nextToken());
        int m = Integer.parseInt(stt.nextToken());


        for(int i=0;i<n;i++){
            if(i==n-1)sb.append(br.readLine());
            else sb.append(br.readLine()).append('\n');
        }

        StringTokenizer st = new StringTokenizer(sb.toString(),"\n");

        for(int i=0;i<n;i++){
            reversMap.put(Integer.toString(i+1),st.nextToken());
            map.put(reversMap.get(Integer.toString(i+1)),Integer.toString(i+1));
        }

        for(int i=0;i<m;i++){
            String str = br.readLine();
            if(map.containsKey(str)) System.out.println(map.get(str));
            if(reversMap.containsKey(str)) System.out.println(reversMap.get(str));
        }

    }
}
