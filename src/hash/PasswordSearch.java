package hash;
// 백준 | 해시맵 | 실버4
// 17219 번 : 비밀번호 찾기
// 시간 제한 : 5초, 메모리 제한 : 256 MB
// 25.05.24
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PasswordSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i=0;i<m;i++){
            if(i==m-1) sb.append(map.get(br.readLine()));
            else sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.println(sb.toString());

    }
}
