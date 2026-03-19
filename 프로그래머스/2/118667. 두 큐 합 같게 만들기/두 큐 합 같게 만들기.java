import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = 0, q2Sum = 0;
        int count = 0, maxSize = (queue1.length + queue2.length) * 2;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int n : queue1){
            q1.offer(n);
            q1Sum += n;
        }
        for(int n : queue2){
            q2.offer(n);
            q2Sum += n;
        }
        
        long sum = q1Sum + q2Sum;
        
        if(sum % 2 != 0)  return -1;
        
        while(true){
            if(q1.isEmpty() || q2.isEmpty() || count > maxSize) return -1;
            
            if(q1Sum > q2Sum){
                int n = q1.poll();
                q2.offer(n);
                q1Sum -= n;
                q2Sum += n;
                count++;
            }else if(q2Sum > q1Sum){
                int n = q2.poll();
                q1.offer(n);
                q1Sum += n;
                q2Sum -= n;
                count++;
            }else return count;
        }
        
    }
}