import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder answer  = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            backDfs(new StringBuilder().append(i),0, i);
        }
        System.out.println(answer);
    }

    static void backDfs(StringBuilder sb, int depth, int idx){
        depth++;
        if(depth==M) {
            answer.append(sb).append("\n");
            return;
        }

        for(int i=idx;i<=N;i++) {
            backDfs(new StringBuilder(sb).append(" ").append(i),depth, i);
        }
    }
}
