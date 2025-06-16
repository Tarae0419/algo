import java.util.*;

class Solution {
    static Set<Integer> visited;
    static List<List<Integer>> answer;
    static int[] a;
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        a = new int[length];
        visited = new HashSet<>();
        answer = new ArrayList<>();

        bt(0, length, nums);

        return answer;
    }

    public static void bt(int depth, int length, int[] nums){
        if(depth == length){
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < length; i++){
                arr.add(a[i]);
            }
            answer.add(arr);
            return;
        }

        for(int i = 0; i < length; i++){
            if(!visited.contains(i)){
                visited.add(i);
                a[depth] = nums[i];
                bt(depth + 1, length, nums);
                visited.remove(i);
            }
        }
    }
}