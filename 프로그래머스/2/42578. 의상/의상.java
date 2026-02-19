import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hs = new HashMap<>();
        
        for(String[] cloth : clothes){
            String type = cloth[1];
            
            hs.put(type, hs.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for(int cnt : hs.values()){
            answer *= (cnt + 1);
        }
        
        return answer - 1;
    }
}