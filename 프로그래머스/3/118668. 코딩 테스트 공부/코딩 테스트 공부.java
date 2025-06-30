import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        for (int[] problem : problems) {
            int alpReq = problem[0];
            int copReq = problem[1];
            maxAlp = Math.max(maxAlp, alpReq);
            maxCop = Math.max(maxCop, copReq);
        }
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        int[][] dp = new int[maxAlp + 2][maxCop + 2];

        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= maxAlp; i++){
            for(int j = cop; j <= maxCop; j++){
                
                if(i + 1 <= maxAlp){
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if(j + 1 <= maxCop){
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                for(int[] problem : problems){
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];
                    
                    if(i >= alp_req && j >= cop_req){
                        int nextAlp = Math.min(i + alp_rwd, maxAlp);
                        int nextCop = Math.min(j + cop_rwd, maxCop);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                }
            }
        }
        return dp[maxAlp][maxCop];
    }
}