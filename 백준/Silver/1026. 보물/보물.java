import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];
        int sum = 0;

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(st1.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr1,Collections.reverseOrder());
        Arrays.sort(arr2);

        for(int i=0;i<n;i++){
            sum += arr1[i]*arr2[i];
        }

        System.out.println(sum);

    }
}
