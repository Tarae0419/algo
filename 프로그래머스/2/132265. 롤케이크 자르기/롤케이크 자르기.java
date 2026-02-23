import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> right = new HashMap<>();
        for(int tp : topping){
            right.put(tp, right.getOrDefault(tp, 0) + 1);
        }
        Set<Integer> left = new HashSet<>();
        int result = 0;
        
        for(int i = 0; i < topping.length - 1; i++){
            int a = topping[i];
            
            left.add(a);
            
            right.put(a, right.getOrDefault(a, 0) - 1);
            if(right.get(a) == 0) right.remove(a);
            
            if(left.size() == right.size()) result++;
        }
        
        return result;
    }
}