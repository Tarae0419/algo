import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> hs = new HashSet<>();
        int n = elements.length;
        
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += elements[(i + j) % n];
                hs.add(sum);
            }
        }
        
        return hs.size();
    }
}