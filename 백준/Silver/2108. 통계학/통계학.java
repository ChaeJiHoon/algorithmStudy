import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        Integer[] arr = new Integer[8001];
        int n = Integer.parseInt(br.readLine());
        int[] midArr = new int[n];

        double sum = 0;
        int mid = n/2;

        for(int i=0;i<=8000;i++) {
            arr[i] = 0;
        }

        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            midArr[i] = num;
            arr[num+4000]++;
        }

        int max = 0;

        for(int i=0;i<arr.length;i++){
            if(max< arr[i]) max = arr[i];
        }

        for(int i=0;i<arr.length;i++){
            if(max==arr[i]) {
                list.add(i);
            }
        }

        Arrays.sort(midArr);

        for (int i : midArr) sum += i;

        System.out.println((int)Math.round(sum/n));         // 산술 평균
        System.out.println(midArr[mid]);                    // 중앙 값

        if(list.size()==1)System.out.println(list.remove(0)-4000);                    // 최빈값
        else System.out.println(list.remove(1)-4000);                    // 최빈값
        System.out.println(midArr[n-1] - midArr[0]);              // 범위

    }

}
