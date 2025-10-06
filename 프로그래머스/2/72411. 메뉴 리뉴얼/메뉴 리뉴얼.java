import java.util.*;

class Solution {
    static HashMap<String, Integer>[] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap[11];
        for (int i = 0; i <= 10; i++) map[i] = new HashMap<>();

        boolean[] want = new boolean[11];
        for (int c : course) want[c] = true;

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            int L = sorted.length();
            visited = new boolean[L];
            for (int len=2;len<=Math.min(10, L);len++) { 
                if(!want[len]) continue;                    
                dfs(sorted, len, 0, 0);
            }
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int target : course) {
            PriorityQueue<Food> pq = new PriorityQueue<>();
            for (String s : map[target].keySet()) {
                pq.add(new Food(s, map[target].get(s)));
            }

            if (pq.isEmpty()) continue;

            int topCnt = pq.peek().cnt;
            if (topCnt <= 1) continue; 

            while (!pq.isEmpty() && pq.peek().cnt == topCnt) {
                ans.add(pq.poll().food);
            }
        }

        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for (int i=0;i<answer.length;i++) answer[i] = ans.get(i);
        return answer;
    }

    static class Food implements Comparable<Food> {
        String food;
        int cnt;

        Food(String food, int cnt) {
            this.food = food;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Food f) {
            return Integer.compare(f.cnt, this.cnt);
        }
    }

    static void dfs(String str, int len, int depth, int idx) {
        if (depth == len) {
            sb.setLength(0);
            for (int i=0;i<str.length();i++) if (visited[i]) sb.append(str.charAt(i));
            String s = sb.toString();
            map[len].put(s, map[len].getOrDefault(s,0) + 1);
            return;
        }
        if (idx >= str.length()) return;

        for (int i=idx;i<str.length();i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(str, len, depth+1, i+1); 
            visited[i] = false;
        }
    }
}
