import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> arr = new PriorityQueue<>();
        
        for(int i = 0; i < score.length; i++){
            arr.add(score[i]);
            
            if(arr.size() > k){
                arr.poll();
            }
            
            answer[i] = arr.peek();
        }
        return answer;
    }
}