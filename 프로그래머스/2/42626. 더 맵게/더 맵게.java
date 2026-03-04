import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int scov : scoville){
            pq.add((long) scov);
        }
        
        int answer = 0;
        
        while(pq.peek() < K){
            if(pq.size() < 2) return -1;
            
            long first = pq.poll();
            long second = pq.poll();         
            long mixScov = first + second * 2;          
            pq.add(mixScov);
            answer++;
            
        }
        return answer;
    }
}