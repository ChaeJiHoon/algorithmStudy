import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int min1 = 0;
        int min2 = 0;
        int min = 2_000_000;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<n;i++){
            if(min>arr[i-1]+arr[i]){
                min = arr[i-1]+arr[i];
                min1 = arr[i-1];
                min2 = arr[i];
            }
        }

        int answer = min1*x + min2*x;
        System.out.println(answer);
    }

}
