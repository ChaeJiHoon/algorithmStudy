import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2,N)-1)).append('\n');
        
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int N, int start, int mid, int to) {
        if(N==1){
            sb.append(start + " " + to + "\n");
            return;
        }

        hanoi(N-1, start, to, mid);
        sb.append(start + " " + to + "\n");
        hanoi(N-1, mid, start, to);
    }
}