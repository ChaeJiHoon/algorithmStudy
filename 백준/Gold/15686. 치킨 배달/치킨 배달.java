import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]> homeList = new ArrayList<>();
    static List<int[]> chickenList = new ArrayList<>();
    static int N, M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 지도 입력
        for (int i = 0; i < N; i++) { 
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) homeList.add(new int[]{i, j});
                else if (val == 2) chickenList.add(new int[]{i, j});
            }
        }

        comb(new ArrayList<>(), 0);

        System.out.println(min);
    }

    
    // 치킨집 조합 선택 함수
    static void comb(List<int[]> selected, int idx) {
        // 지정한 거리가 되면
        if (selected.size() == M) {
            int total = 0;

            // 각 집에 대해 최소 치킨 거리 계산
            for (int[] home : homeList) {
                int dist = Integer.MAX_VALUE;
                for (int[] chicken : selected) {
                    int d = Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
                    dist = Math.min(dist, d);
                }
                total += dist;
            }

            min = Math.min(min, total);
            return;
        }

        // 킥 포인트, 재귀, 백트래킹, 조합!!!!!!!!
        for (int i = idx; i < chickenList.size(); i++) {
            selected.add(chickenList.get(i));
            comb(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
}
