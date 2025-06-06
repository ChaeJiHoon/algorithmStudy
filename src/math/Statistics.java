package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>(); // <숫자, 빈도>

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double sum = 0;
        int mid = n/2;


        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);           // 숫자 넣으면서 빈도 체크
        }

        Arrays.sort(arr);

        for (int i : arr) sum += i;

        List<Integer> list = new ArrayList<>(map.keySet());
        int[][] marr = new int[list.size()][2];

        int listSize = list.size();

        for(int i=0;i<listSize;i++){
            int a = list.remove(0);
            marr[i][0] = a;
            marr[i][1] = map.get(a);
        }

        Arrays.sort(marr, (int[] o1, int[] o2) ->{
            if(o1[1]==o2[1]) return o2[0]-o1[0];
            else return o2[1]-o1[1];
        });

        int l = 1;
        int index=1;
        while(index< marr.length-1){
            if(marr[index-1][1]==marr[index][1]) l++;
            else break;
            index++;
        }

        System.out.println((int)Math.round(sum/n));         // 산술 평균
        System.out.println(arr[mid]);                       // 중앙 값
        if(l==1) System.out.println(marr[0][0]);
        else System.out.println(marr[l-2][0]);
        System.out.println(arr[n-1] - arr[0]);              // 범위

    }

}
