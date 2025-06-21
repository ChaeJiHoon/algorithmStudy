package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ExpressedN {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        System.out.println(sol.solution(5, 12));

    }
}

class Solution1 {
    public int solution(int N, int number) {

        List<HashSet<Integer>> basket = new ArrayList<>();

        for(int i=0;i<=8;i++) basket.add(new HashSet<Integer>());

        basket.get(1).add(N);
        if(number ==N) return 1;

        for(int i=2; i<=8; i++) {
            // 통, 2번째통, 3번째통...
            HashSet<Integer> total = basket.get(i);

            for(int j=1; j<i; j++) {
                // 만약 j=3 인경우
                // 2번통과 1번통의 조합으로 다 순회
                HashSet<Integer> a = basket.get(j);
                HashSet<Integer> b = basket.get(i-j);

                for(int x:a) {
                    for(int y:b) {
                        total.add(x+y);
                        total.add(x-y);
                        total.add(x*y);
                        if(x!=0 && y!=0) total.add(x/y);
                    }
                }
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }

            if(total.contains(number)) return i;
        }

        return -1;
    }
}