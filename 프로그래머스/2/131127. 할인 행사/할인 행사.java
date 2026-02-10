import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        int count = 0;
        for(int i = 0; i <= discount.length - 10; i++){
            if(isMatch(wantMap, discountMap)) count++;
            
            if(i < discount.length - 10){
                String item = discount[i];
                if(discountMap.get(item) == 1) discountMap.remove(item);
                else discountMap.put(item, discountMap.get(item) - 1);
            
                String in = discount[i + 10];
                discountMap.put(in, discountMap.getOrDefault(in, 0) + 1);
            }
        }
        
        return count;
    }
    
    public boolean isMatch(Map<String, Integer> wantMap, Map<String, Integer> discountMap){
        for(String key : wantMap.keySet()){
            if(wantMap.get(key) > discountMap.getOrDefault(key, 0)) return false;
        }
        return true;
    }
}