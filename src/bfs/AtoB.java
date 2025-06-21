package bfs;
// 백준 | bfs | 실버2
// 16953 번 : A to B
// 시간 제한 : 2초, 메모리 제한 : 512 MB
// 25.06.18

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AtoB {
    static long A, B;
    static int cnt = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        bfs();
        System.out.println(cnt);
    }

    static void bfs() {
        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{A, 1});
        Set<Long> visited = new HashSet<>();
        visited.add(A);

        while (!q.isEmpty()) {
            long[] arr = q.poll();
            long current = arr[0];
            long count = arr[1];

            if (current == B) {
                cnt = (int) count;
                return;
            }

            long next1 = current * 2;
            long next2 = current * 10 + 1;

            if (next1 <= B && !visited.contains(next1)) {
                q.add(new long[]{next1, count + 1});
                visited.add(next1);
            }

            if (next2 <= B && !visited.contains(next2)) {
                q.add(new long[]{next2, count + 1});
                visited.add(next2);
            }
        }
    }
}
