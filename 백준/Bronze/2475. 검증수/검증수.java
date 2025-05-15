import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr= new int[st.countTokens()];

        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] *= arr[i];
        }

        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        System.out.println(sum%10);


    }

}
