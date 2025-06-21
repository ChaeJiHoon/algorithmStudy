package binarySearch;
// 백준 | 이분탐색 | 실버 2
// 2805 번 : 나무 자르기
// 시간 제한 : 1초, 메모리 제한 : 256 MB
// 25.06.08
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingTree {
    static int[] arr;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>max) max = arr[i];
        }

        while (min<max){
            int mid = (min+max) / 2;
            long sum = 0;
            for(int tree : arr){
                if(tree-mid > 0) sum += (tree - mid);
            }

            if(sum < m) max = mid;
            else min = mid + 1;
        }
        System.out.println(min - 1);

    }
}
