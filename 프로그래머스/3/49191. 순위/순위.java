class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] beats = new boolean[n + 1][n + 1];
        
        for(int[] result : results){
            int winner = result[0];
            int loser = result[1];
            beats[winner][loser] = true;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(beats[i][k] && beats[k][j]){
                        beats[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int known = 0;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(beats[i][j] || beats[j][i]) known++;
            }
            if(known == n - 1) answer++;
        }
        
        return answer;
    }
}