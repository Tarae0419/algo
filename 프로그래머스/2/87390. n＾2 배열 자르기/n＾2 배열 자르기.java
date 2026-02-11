import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        
        for(long i = left; i <= right; i++){
            if(((int)(i % n) + 1) < ((int)(i / n) + 1)) list.add((int)(i / n) + 1);
            else list.add((int)(i % n) + 1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}