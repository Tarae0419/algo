import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) pq.offer(work);
        
        for(int i = 0; i < n; i++){
            int max = pq.poll();
            
            if(max == 0) break;
            
            pq.offer(max - 1);
        }
        
        return pq.stream()
            .mapToLong(x -> (long) x * x)
            .sum();
    }
}