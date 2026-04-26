import java.util.*;

class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add(num);
        }

        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            answer[i] = pq.poll();
        }

        return answer;
    }
}