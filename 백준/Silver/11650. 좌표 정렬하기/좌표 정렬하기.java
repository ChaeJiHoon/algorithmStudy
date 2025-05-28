import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, (e1,e2) -> {
            if(e1[0] == e2[0]) return e1[1] - e2[1];
            else return e1[0] - e2[0];
        });

        for(int i=0;i<n;i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]+"\n");
        }

        System.out.println(sb.toString());
    }
}
