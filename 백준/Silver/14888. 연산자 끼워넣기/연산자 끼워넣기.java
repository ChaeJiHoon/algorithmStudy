import java.util.*;
import java.io.*;

public class Main {
    static int[] numArr;
    static String[] operArr;
    static boolean[] visited;
    static int N, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numArr = new int[N];
        operArr = new String[N-1];     // +,-,*,/
        visited = new boolean[N-1];     // +,-,*,/

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) numArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int index = 0;
        for(int i=0;i<4;i++) {
            int n = Integer.parseInt(st.nextToken());
            for(int j=0;j<n;j++){
                if(i==0) operArr[index++] = "+";
                else if(i==1) operArr[index++] = "-";
                else if(i==2) operArr[index++] = "*";
                else operArr[index++] = "/";
            }
        }

        dfs(numArr[0],0);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int ans ,int depth){

        if(depth==N-1){
            max = Math.max(max, ans);
            min = Math.min(min, ans);
        }

        for(int i=0;i<N-1;i++){
            if(visited[i]) continue;
            visited[i] = true;
            int nAns = ans;

            if(operArr[i].equals("+")) nAns += numArr[depth+1];
            else if(operArr[i].equals("-")) nAns -= numArr[depth+1];
            else if(operArr[i].equals("*")) nAns *= numArr[depth+1];
            else {
                if(nAns<0) nAns = -(Math.abs(nAns)/numArr[depth+1]);
                else nAns /= numArr[depth+1];
            }
            dfs(nAns, depth+1);

            visited[i] = false;
        }
    }

}
