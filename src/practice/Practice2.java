package practice;
import java.io.*;

public class Practice2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t+1];

        for(int i=1;i<=t;i++){
            int leng =Integer.toString(i).length();
            int index = i;
            for(int j=0;j<leng;j++){
                arr[i] += index%10;
                index = index/10;

            }
            arr[i] = arr[i] + i;

        }

        int c =0;
        for(int i=1;i<=t;i++){
            if(arr[i]==t) {
                System.out.println(i);
                c++;
                break;
            }
        }
        if(c==0) System.out.println(0);

    }
}
