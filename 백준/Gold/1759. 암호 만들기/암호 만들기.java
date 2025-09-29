import java.io.*;
import java.util.*;

public class Main {
    static int L,C;
    static String[] arr;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();
    static HashMap<Integer, String> map = new HashMap<>();

    static StringBuilder sb;
    static StringBuilder sbd = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<C;i++) arr[i] = st.nextToken();
        Arrays.sort(arr);

        // 인덱스에 맞춰서 문자열 삽입
        for(int i=0;i<C;i++) map.put(i,arr[i]);

        dfs(0,0);

        System.out.print(sbd);
    }

    static void dfs(int index, int depth){

        if(depth==L){
            sb = new StringBuilder();

            for(int i=0;i<C;i++) if(visited[i]) sb.append(map.get(i));
            String str = sb.toString();
            if(vowelCheck(str) && !set.contains(str)){
                sbd.append(str).append("\n");
                set.add(str);
            }
            return;
        }


        for(int i=index;i<C;i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }

    static boolean vowelCheck(String str){
        int cnt = 0;

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') cnt++;
        }

        return cnt != 0 && cnt<L-1;
    }
}