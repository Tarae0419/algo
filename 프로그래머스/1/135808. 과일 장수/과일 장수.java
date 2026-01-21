import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        score = Arrays.stream(score)
              .boxed() 
              .sorted(Collections.reverseOrder())
              .mapToInt(i -> i)
              .toArray();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : score){
            pq.add(s);
            
            if(pq.size() == m){
                answer += pq.poll() * m;
                pq.clear();
            }
        }
        
        return answer;
    }
}