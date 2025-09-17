import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static ArrayList<Integer>[] rArr; // 행 배열(각 행이 가변 길이)
    static final int LIM = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력은 1-based 좌표 → 내부는 0-based로, 존나 크랙
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());

        rArr = new ArrayList[3];
        for (int i=0;i<3;i++) rArr[i] = new ArrayList<>();

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<3;j++) rArr[i].add(Integer.parseInt(st.nextToken()));
        }

        // t=0 체크
        if(getVal(r,c)==k){
            System.out.println(0);
            return;
        }

        int time = 0;
        while(time<100){
            time++;

            int rowCount = rArr.length;
            int colCount = getMaxLen(rArr);

            if (rowCount >= colCount) {
                // R 연산: 각 "행"을 정렬 규칙으로 변환
                rArr = operateRC(rArr);
            } else {
                // C 연산: 전치 → R처럼 처리 → 다시 전치
                ArrayList<Integer>[] cArr = transpose(rArr);
                cArr = operateRC(cArr);
                rArr = transpose(cArr);
            }

            if (getVal(r, c) == k) { System.out.println(time); return; }
        }
        System.out.println(-1);
    }

    // 현재 (r,c) 값 (범위 밖/짧은 행인 경우 0 처리)
    static int getVal(int rr, int cc) {
        if (rr < 0 || rr >= rArr.length) return 0;
        ArrayList<Integer> row = rArr[rr];
        if (cc < 0 || cc >= row.size()) return 0;
        return row.get(cc);
    }

    // 배열 최대 열 길이 확인
    static int getMaxLen(ArrayList<Integer>[] arr) {
        int m=0;
        for (ArrayList<Integer> row : arr) m = Math.max(m, row.size());
        return m;
    }

    // R/C 공통 연산: 각 라인(행 또는 열)마다
    //   1) 0 제외 카운트
    //   2) (수, 등장횟수) 쌍 만들기
    //   3) 등장횟수 오름차순 → 수 오름차순
    //   4) [수,횟수,수,횟수,...] 로 펼치고 길이 100 제한
    //   5) 모든 라인을 최대 길이에 맞춰 0으로 패딩

    static ArrayList<Integer>[] operateRC(ArrayList<Integer>[] arr) {
        int n = arr.length;
        ArrayList<Integer>[] out = new ArrayList[n];
        int maxLen = 0;

        for (int i=0;i<n;i++) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int v : arr[i]) {
                if(v==0) continue;         // 0은 제외
                cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            }

            // (수,횟수) 쌍 리스트
            ArrayList<int[]> pairs = new ArrayList<>(cnt.size());
            for (Map.Entry<Integer,Integer> e : cnt.entrySet()) {
                pairs.add(new int[]{e.getKey(), e.getValue()});
            }

            pairs.sort((a, b) -> {
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });

            // 펼치기
            ArrayList<Integer> line = new ArrayList<>();
            for (int[] p : pairs) {
                line.add(p[0]);
                line.add(p[1]);
                if (line.size() >= LIM) break; // 100 제한
            }

            // 길이 업데이트
            maxLen = Math.max(maxLen, line.size());
            out[i] = line;
        }

        // 패딩
        if (maxLen>LIM) maxLen = LIM;
        for(int i=0;i<n;i++){
            while (out[i].size()<maxLen) out[i].add(0);
        }
        return out;
    }

    // 전치(행<->열). ragged 배열 대응: 없는 칸은 0으로 채움
    static ArrayList<Integer>[] transpose(ArrayList<Integer>[] rows) {
        int R = rows.length;
        int C = getMaxLen(rows);
        ArrayList<Integer>[] cols = new ArrayList[C];
        for (int j=0;j<C;j++) cols[j] = new ArrayList<>();

        for(int j=0;j<C;j++){
            for(int i=0;i<R;i++){
                int v = (j<rows[i].size()) ? rows[i].get(j) : 0;
                cols[j].add(v);
            }
        }
        return cols;
    }
}
