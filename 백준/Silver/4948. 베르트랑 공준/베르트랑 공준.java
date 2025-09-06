import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;

            boolean[] prime = new boolean[n*2+1];

            prime[0] = true;
            prime[1] = true;

            for(int i=2;i<=Math.sqrt(prime.length);i++){
                if(prime[i]) continue;

                for(int j=i*i;j<prime.length;j=j+i) prime[j] = true;
            }
            int cnt = 0;
            for(int i=n+1;i<=n*2;i++) if(!prime[i]) cnt++;
            sb.append(cnt).append("\n");
        }

        System.out.print(sb.toString().trim());
    }
}