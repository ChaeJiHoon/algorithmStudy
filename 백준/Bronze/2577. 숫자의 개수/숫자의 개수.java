import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] arr = new int[10];

        String[] strarr = Integer.toString(A*B*C).split("");

        for(int i=0; i<=9;i++){
            for(int j=0;j<strarr.length;j++){
                if(i == Integer.parseInt(strarr[j])) arr[i]++;
            }
            System.out.println(arr[i]);
        }
    }
}
