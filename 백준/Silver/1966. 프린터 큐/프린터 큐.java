import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            // 인덱스와 순위 저장
            // ar[0] = 인덱스, ar[1] = 우선 순위
            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<a;j++){
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;

            while(!q.isEmpty()){

                int[] first = q.poll();
                boolean isMax = true;

                for (int[] item : q) {
                    if (item[1] > first[1]) { // 더 높은 우선순위가 있다면
                        q.offer(first); // 현재 문서를 다시 맨 뒤로
                        isMax = false;
                        break;
                    }
                }

                if(!isMax) continue;
                cnt++;
                if (first[0]==target) break;
            }

            sb.append(cnt).append('\n');
        }
        System.out.println(sb);



    }
}


