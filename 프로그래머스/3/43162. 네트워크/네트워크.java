class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];  // 방문 확인 배열

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                answer++;  // 한 번의 DFS가 하나의 네트워크로 생각
            }
        }

        return answer;
    }

    private void dfs(int current, boolean[] visited, int[][] computers) {
        visited[current] = true;

        for (int j = 0; j < computers.length; j++) {
            
            if (computers[current][j] == 1 && !visited[j]) {
                dfs(j, visited, computers);
            }
        }
    }
}
