import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double sum = 0;
        double ave = 0;

        double a = (double)n/100*15;
        int b = (int)Math.round(a);

        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i=b+1;i<=n-b;i++){
            sum += arr[i];
        }

        ave = Math.round(sum/(double)(n-2*b));

        System.out.println((int)ave);

    }
}
