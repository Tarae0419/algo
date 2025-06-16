import java.util.*;

class Solution {
    List<List<Integer>> answer;
    int[] a;
    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        a = new int[k];

        bt(0, 1, n, k);

        return answer;
    }
    public void bt(int depth, int start, int n, int k){
        if(depth == k){
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < k; i++){
                arr.add(a[i]);
            }
            answer.add(arr);
            return;
        }

        for(int i = start; i <= n; i++){
            a[depth] = i;
            bt(depth + 1, i + 1, n, k);
        }
    }
}