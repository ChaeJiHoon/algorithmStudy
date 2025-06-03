import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        prime = new boolean[n+1];

        // 0과 1은 소수가 아님
        prime[0] = true;
        prime[1] = true;

        for(int i=0;i<=Math.sqrt(prime.length);i++){
            if(prime[i]) continue;

            for(int j=i*i;j<prime.length;j=j+i){
                prime[j] = true;
            }
        }

        for(int i=m;i<=n;i++){
            if(!prime[i]) sb.append(i).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

}
