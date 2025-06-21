package backTracking;
// 백준 | 백트래킹 | 실버 3
// 15652 번 : N과M(4)
// 시간 제한 : 1초, 메모리 제한 : 512 MB
// 25.06.11

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM4 {
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
