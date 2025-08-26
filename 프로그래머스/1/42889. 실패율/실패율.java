import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] cnt = new int[N+2]; // 1~N, N+1 = 올클
        for(int s : stages) if(1<=s&&s<=N) cnt[s]++;
        
        // 실패율 배열
        double[] fail = new double[N+1]; // 1~N
        
        int remain = stages.length;      // 해당 스테이지에 도달한 사람 수
        for (int i=1;i<=N;i++){
            if(remain==0)fail[i] = 0.0;
             else{
                fail[i] = (double)cnt[i]/remain;
                remain -= cnt[i];
            }
        }

        // 우선순위큐(실패율 내림차순, 같으면 스테이지 오름차순)
        PriorityQueue<Sta> pq = new PriorityQueue<>();
        for (int i=1;i<=N;i++) pq.add(new Sta(i, fail[i]));

        int[] answer = new int[N];
        for (int i=0;i<N;i++) answer[i] = pq.poll().stage;
        return answer;
    }

    static class Sta implements Comparable<Sta>{
        int stage;
        double fail;
        Sta(int stage, double fail){ 
            this.stage = stage; 
            this.fail = fail;
        }

        @Override
        public int compareTo(Sta o){
            if (this.fail == o.fail) return this.stage - o.stage; // 작은 번호 먼저
            return (this.fail < o.fail) ? 1 : -1; // 실패율 내림차순
        }
    }
}
