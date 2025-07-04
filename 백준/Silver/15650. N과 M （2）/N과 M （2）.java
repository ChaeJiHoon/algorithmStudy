import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            backDfs(0,i, i+"");
        }

    }

    static void backDfs(int depth, int idx, String str){
        depth++;
        if(depth==M) {
            System.out.println(str);
            return;
        }

        for(int i=idx+1;i<=N;i++){
            backDfs(depth, i,str + " " + i);
        }

    }
}
