class Solution {
    static boolean[] visited;
    static int[][] dgs;
    static int answer = 0;
    static int n;
    public int solution(int k, int[][] dungeons) {
        
        n = dungeons.length;
        dgs = new int[n][2];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++) dgs[i][j] = dungeons[i][j];
        }
        
        for(int i=0;i<n;i++){
            visited = new boolean[n];
            if(k-dgs[i][0]>=0){
                visited[i] = true;
                dfs(i,k,0);
                visited[i] = false;
            }
        }
        
        
        
        return answer;
    }
    
    static void dfs(int now, int k, int index){
        k -= dgs[now][1];
        index++;
        for(int i=0;i<n;i++){
            if(!visited[i] && k-dgs[i][0]>=0) {
                visited[i] = true;
                dfs(i, k,index);
                visited[i] = false;
            }
        }
        
        answer = Math.max(index,answer);
    }
    
}