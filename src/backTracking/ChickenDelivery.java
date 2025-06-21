package backTracking;
// 백준 | 백트래킹, 재귀| 골드 5
// 15682 번 : 치킨 배달
// 시간 제한 : 1초, 메모리 제한 : 512 MB
// 25.06.11

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ChickenDelivery {
    static int sum = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //  집 좌표 리스트
        List<int[]> homeList = new ArrayList<>();
        // 치킨 집 좌표, 치킨 거리 총합
        List<int[]> chickenList = new ArrayList<>();

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                int num = Integer.parseInt(st.nextToken());
                // 집 리스트
                if(num==1) {
                    int[] chickenMap = {i,j};
                    homeList.add(chickenMap);
                }else if(num==2){   // 치킨 리스트
                    int[] chickenMap = {i,j,0};
                    chickenList.add(chickenMap);
                }
            }
        }

        for (int[] chicken : chickenList) {
            for (int[] home : homeList) {
                // 치킨 거리
                int sum = Math.abs(chicken[0] - home[0]) + Math.abs(chicken[1] - home[1]);

                // 각 치킨 집당 치킨거리 누적
                chicken[2] += sum;
            }
        }

        Collections.sort(chickenList,((o1, o2) -> o1[2]-o2[2]));

        int sum = 0;
        for (int[] home : homeList) {
            int min = Integer.MAX_VALUE;
            for(int i=0;i<M;i++){
                int num = Math.abs(chickenList.get(i)[0] - home[0]) + Math.abs(chickenList.get(i)[1] - home[1]);
                // 치킨 거리
                if (min > num) min = num;
            }
            sum += min;
        }

        System.out.println(sum);

    }

}

/*
1 0 0 0 0 2 0 0 0 0 1
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2
 */