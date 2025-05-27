import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int q = 0;
        int answer = 0;
        if(arr[1]-arr[0] == arr[2]-arr[1]) {
            q = arr[1]-arr[0];
            answer = arr[n-1]+q;
        }
        else {
            q = arr[1]/arr[0];
            answer = arr[n-1]*q;
        }
        System.out.println(answer);

    }
}
