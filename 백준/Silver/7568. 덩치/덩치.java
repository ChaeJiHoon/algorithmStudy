import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            int count = 1;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]){  // arr[i] 가 arr[j] 덩치가 더 작은 경우
                    count++;                                     // 즉, 자기보다 큰사람이 있는 경우에만 등수가 내려감
                }
            }
            arr[i][2] = count;
            sb.append(arr[i][2]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}