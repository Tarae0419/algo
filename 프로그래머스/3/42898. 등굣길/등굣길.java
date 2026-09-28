import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                if(isPuddles(puddles, i, j)) continue;

                if(i == 0) dp[i][j] = dp[i][j - 1];
                else if (j == 0)dp[i][j] = dp[i - 1][j];
                else dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    public boolean isPuddles(int[][] puddles, int x, int y) {
        for(int[] puddle : puddles){
            if(puddle[0] == x + 1 && puddle[1] == y + 1) return true;
        }
        return false;
    }
}