class Solution {
    public int solution(int n) {
        int answer = 0;
        double sqrt = Math.sqrt(n);
        
        for(int i = 1; i <= sqrt; i++){
            if(n % i != 0) continue;
            
            answer += i;
            
            if (n / i != i){
                answer += n / i;
            }
        }
        return answer;
    }
}