package Sort;
// 백준 | 정렬| 브론즈 1
// 10989 번 : 숫자 정렬하기 3
// 시간 제한 : 3초, 메모리 제한 : 512 MB
// 25.05.27
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSort3 {
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
