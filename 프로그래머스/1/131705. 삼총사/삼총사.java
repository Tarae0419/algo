class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for(int i = 2; i < number.length; i++){
            for(int j = 1; j < i; j++){
                for(int k = 0; k < j; k++){
                    int num = number[i] + number[j] + number[k];
                    if(num == 0) answer++;
                }
            }
        }
        
        return answer;
    }
}