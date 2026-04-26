import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            return (b + a).compareTo(a + b);
        });

        for(int num : nums){
            pq.add(String.valueOf(num));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        String answer = sb.toString();
        return answer.charAt(0) == '0' ? "0" : sb.toString();
    }
}