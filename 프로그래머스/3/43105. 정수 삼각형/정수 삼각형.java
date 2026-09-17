class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[triangle.length + 1][triangle.length + 1];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0) dp[i][j] = triangle[i][j] + dp[i - 1][j];
                else if(j == i) dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j],  + dp[i - 1][j - 1]);
            }
        }
        
        int max = 0;
        
        for(int i = 1; i < triangle.length; i++){
            max = Math.max(max, dp[n - 1][i]);
        }
        
        return max;
    }
}