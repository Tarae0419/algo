import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
        
        int answer = 0;
        
        for(int a : A) pqA.offer(a);
        for(int b : B) pqB.offer(b);
        
        while(!pqA.isEmpty()){
            int numA = pqA.poll();
            int numB = pqB.poll();
            
            if(numA >= numB) pqB.offer(numB);
            else answer++;
        }
        
        return answer;
    }
}