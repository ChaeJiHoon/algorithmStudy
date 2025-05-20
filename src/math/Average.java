package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Average {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[n];
        double max = 0;

        for(int i=0;i<n;i++){
            arr[i] = Double.parseDouble(st.nextToken());
            if(arr[i]>max) max = arr[i];
        }
        double sum = 0;

        for(int i=0;i<n;i++){
            arr[i] = arr[i]/max;
            sum += arr[i];
        }
        System.out.println((sum/n)*100.0);
    }
}
