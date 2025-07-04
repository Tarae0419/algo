class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        bt(0, nums, answer, current);
        return answer;
    }

    public void bt(int depth, int[] nums, List<List<Integer>> answer, List<Integer> current){
        answer.add(new ArrayList<>(current));

        for(int i = depth; i < nums.length; i++){
            current.add(nums[i]);
            bt(i + 1, nums, answer, current);
            current.remove(current.size() - 1);
        }
    }

}