class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];
            
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k){
                int currentLen = right - left + 1;
                
                if(currentLen < minLen){
                    minLen = currentLen;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        return answer;
    }
}