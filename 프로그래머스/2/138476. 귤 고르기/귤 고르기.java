import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int num : tangerine){
            hs.put(num, hs.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(hs.values());
        counts.sort(Collections.reverseOrder());
        
        int count = 0;
        int sum = 0;
        for(int n : counts){
            sum += n;
            count ++;
            
            if(sum >= k) break;
        }
        
        return count;
    }
}