package dijkstra;
// 백준 | 다익스트라 | 골드5
// 1916 번 : 최소 비용 구하기
// 시간 제한 : 0.5초, 메모리 제한 : 128 MB
// 25.06.18

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class FindMinimumCost {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        HashMap<int[], Integer> city = new HashMap<>();
        List<int[]> list = new ArrayList<>();

        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            int[] arr = {from,to};
            list.add(arr);

            {

            }
            city.put(new int[]{from,to},cost);

        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());


    }
}
