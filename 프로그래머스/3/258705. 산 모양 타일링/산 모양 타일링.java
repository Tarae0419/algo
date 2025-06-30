class Solution {
    public int solution(int n, int[] tops) {
        final int MOD = 10007;
        int[][] dp = new int[n + 1][2];

        dp[1][0] = 2 + tops[0];
        dp[1][1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i][0] = (dp[i - 1][0] * (2 + tops[i - 1]) + dp[i - 1][1] * (1 + tops[i - 1])) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        return (dp[n][0] + dp[n][1]) % MOD;
    }
}
