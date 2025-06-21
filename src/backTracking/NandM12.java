package backTracking;
// 백준 | 백트래킹 | 실버 2
// 15666 번 : N과M(12)
// 시간 제한 : 1초, 메모리 제한 : 512 MB
// 25.06.12

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NandM12 {
    static int N,M;
    static int[] numbers;
    static boolean[] used;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    static Set<String> results = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        used = new boolean[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        backTrackingFunc(0,0);

        for(String s : results) sb.append(s).append("\n");

        System.out.println(sb);
    }

    static void backTrackingFunc(int depth, int idx) {
        if(depth==M){
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<M;i++) temp.append(selected[i]).append(" ");
            results.add(temp.toString().trim());
            return;
        }

        for(int i=idx;i<N;i++){
            selected[depth] = numbers[i];
            backTrackingFunc(depth+1,i);
        }
    }
}
