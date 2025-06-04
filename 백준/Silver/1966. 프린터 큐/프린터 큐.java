import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());               // 문서 개수
            int target = Integer.parseInt(st.nextToken());          // 궁금한 문서 인덱스

            Queue<int []> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());       // 큰수부터 정렬하는 우선순위 큐 저장

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                int priorty = Integer.parseInt(st.nextToken());     // 우선순위
                q.offer(new int[]{i,priorty});                      // 인덱스, 우선순위 저장
                pq.offer(priorty);                                  // 우선순위 큐에는 우선순위만 저장
            }

            int cnt = 0;
            while(!q.isEmpty()){
                int[] compare = q.poll();                             // 큐에서 첫 데이터를 꺼내서 비교할 배열에 저장

                if(compare[1] == pq.peek()){                        // 우선순위를 비교하고, 현재 문서가 우선순위가 가장 높다면 출력한다.
                    cnt++;                                          // 출력
                    pq.poll();                                      // 최고 우선순위 삭제
                    if(compare[0]==target) break;                          // 이때 타겟 문서면 종료한다.
                }else{
                    q.offer(compare);                               // 아니면 다시 큐 맨뒤로 보냄
                }
            }

            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
