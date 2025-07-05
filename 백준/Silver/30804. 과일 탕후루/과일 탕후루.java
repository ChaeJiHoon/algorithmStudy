import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> fruit = new HashMap<>();

        while(right<N){
            fruit.put(arr[right], fruit.getOrDefault(arr[right],0)+1);
            right++;
            
            while(fruit.size()>2){
                fruit.put(arr[left],fruit.get(arr[left])-1);
                if (fruit.get(arr[left])==0){
                    fruit.remove(arr[left]);
                }
                left++;
            }
            max = Math.max(max, right-left);
        }

        System.out.println(max);
    }
}
