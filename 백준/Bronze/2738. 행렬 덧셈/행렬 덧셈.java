import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        for(int i=0;i<2*n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                if(i<n) arr1[i][j] = Integer.parseInt(st.nextToken());
                else arr2[i-n][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append((arr1[i][j]+arr2[i][j])+" ");
            }
        }

        String str = sb.toString().trim();

        System.out.println(str);

    }
}
