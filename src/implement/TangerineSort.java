package implement;
// 프로그래머스 | 연습문제| Lv.2
// 구현 : 귤 고르기
// 통과 성공
// 25.05.22
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class TangerineSort {
    public static void main(String[] args) {
        Tangerine t = new Tangerine();
        int[] ta = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(t.solution(4, ta));
    }
}

class Tangerine {
    public int solution(int k, int[] tangerine) {
        int n = tangerine.length;
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(tangerine);

        int count = 1;

        for(int i=1;i<n;i++){
            if(tangerine[i]!=tangerine[i-1]){
                q.add(count);
                count = 1;
            }else{
                count++;
            }
        }
        q.add(count);

        int qleng = q.size();
        Integer[] lengArr = new Integer[qleng];

        for (int i=0;i<qleng;i++) {
            lengArr[i] = q.poll();
        }

        Arrays.sort(lengArr, Collections.reverseOrder());

        int answer = 0;
        int sum = 0;
        for(int i=0;i<lengArr.length;i++){
            sum += lengArr[i];
            answer++;
            if(sum>=k) break;
        }

        return answer;
    }
}