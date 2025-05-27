import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10001];

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            int a = Integer.parseInt(br.readLine());
            arr[a]++;
        }

        for(int i=0;i<10001;i++){
            if(arr[i]!=0){
                while(arr[i]>0){
                    sb.append(i).append("\n");
                    arr[i]--;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
