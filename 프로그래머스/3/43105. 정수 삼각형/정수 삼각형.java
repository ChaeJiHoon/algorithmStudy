class Solution{
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length+1][500];
        dp[1][0] = triangle[0][0];

        for(int i=2;i<=triangle.length;i++){
            for(int j=0;j<i;j++){
                if(j==0) dp[i][0] = dp[i-1][0]+triangle[i-1][0];
                else if(j==i-1) dp[i][j] = dp[i-1][j-1]+triangle[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i-1][j];
                }
            }
        }

        for(int i=1;i<=triangle.length;i++){
            answer = Math.max(answer,dp[triangle.length][i]);
        }
        
        return answer;
    }
}