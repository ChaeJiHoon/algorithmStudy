import java.io.*;
import java.util.*;

public class Main {
    // 보석 클래스, 정렬을 위한 Comparable
    static class Jewel implements Comparable<Jewel>{
        int weight;
        int price;

        Jewel(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        // 무게 기준 오름차순 정렬
        @Override
        public int compareTo(Jewel o){
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       // 보석 개수
        int K = Integer.parseInt(st.nextToken());       // 가방 개수

        Jewel[] jewels = new Jewel[N];                  // 배열로 보석 선언
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(weight, price);
        }

        // 무게 오름차순으로 보석 정렬,
        Arrays.sort(jewels);

        int[] bags = new int[K];
        for(int i=0;i<K;i++) bags[i] = Integer.parseInt(br.readLine());

        // 가방 무게 오름차순
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;
        int idx = 0;

        for (int i=0;i<K;i++) {
            int bagWeight = bags[i];

            // 현재 가방에 담을 수 있는 모든 보석 PQ에 추가
            // 인덱스가 0보다 작고, 보석의 무게가 가방 용량 이하 일때
            while (idx<N&&jewels[idx].weight <= bagWeight) {
                pq.add(jewels[idx].price);
                idx++;
            }

            if (!pq.isEmpty()) {
                total += pq.poll(); // 가장 비싼 보석 꺼내기
            }
        }

        System.out.println(total);
    }
}
