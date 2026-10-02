class Solution {
    public int solution(String arr[]) {
        int n = arr.length;
        int[] numbers = new int[n / 2 + 1];
        String[] operaters = new String[n / 2];
        
        int numberIndex = 0;
        int operaterIndex = 0;
        
        for(String s : arr){
            if(s.equals("+") || s.equals("-")) operaters[operaterIndex++] = s;
            else numbers[numberIndex++] = Integer.parseInt(s);
        }
        
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        
        for(int i = 0; i <= n / 2; i++){
            maxDp[i][i] = numbers[i];
            minDp[i][i] = numbers[i];
        }
        
        for(int len = 1; len <= n / 2; len++){
            for(int i = 0; i + len <= n / 2; i++){
                int j = i + len;
                
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;
                
                for(int k = i; k < j; k++){
                    if(operaters[k].equals("+")){
                        int max = maxDp[i][k] + maxDp[k + 1][j];
                        int min = minDp[i][k] + minDp[k + 1][j];
                        
                        maxDp[i][j] = Math.max(maxDp[i][j], max);
                        minDp[i][j] = Math.min(minDp[i][j], min);
                    }
                    else{
                        int max = maxDp[i][k] - minDp[k + 1][j];
                        int min = minDp[i][k] - maxDp[k + 1][j];
                        
                        maxDp[i][j] = Math.max(maxDp[i][j], max);
                        minDp[i][j] = Math.min(minDp[i][j], min);
                    }
                }
            }
        }
        
        return  maxDp[0][n / 2];
    }
}