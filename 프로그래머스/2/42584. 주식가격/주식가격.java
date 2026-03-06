import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++){
            while(!dq.isEmpty() && prices[i] < prices[dq.peekLast()]){
                int j = dq.pollLast();
                answer[j] = i - j;
            }
            dq.addLast(i);
        }
        
        while(!dq.isEmpty()){
            int j = dq.pollLast();
            answer[j] = (prices.length - 1) - j;
        }
        
        return answer;
    }
}