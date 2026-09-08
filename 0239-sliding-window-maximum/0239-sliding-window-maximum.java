import java.util.*;

class Solution {
    static class Node{
        int index;
        int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Node> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        for(int i = 0; i < nums.length; i++){
            if (!dq.isEmpty() && dq.peekFirst().index <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && dq.peekLast().value <= nums[i]) dq.pollLast();

            dq.offerLast(new Node(i, nums[i]));
            
            if (i >= k - 1) result[resultIndex++] = dq.peekFirst().value;
        }

        return result;
    }
}