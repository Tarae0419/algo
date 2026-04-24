class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Node> dq = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int currentNum = nums[i];

            while(!dq.isEmpty() && dq.getLast().value < currentNum){
                dq.removeLast();
            }
            dq.addLast(new Node(i, currentNum));
            if(dq.getFirst().index <= i - k) dq.removeFirst();

            if(i >= k - 1) list.add(dq.getFirst().value);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public class Node{
        int index;
        int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}