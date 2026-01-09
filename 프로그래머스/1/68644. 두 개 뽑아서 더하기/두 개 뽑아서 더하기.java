import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i == j) continue;
                hs.add(numbers[i] + numbers[j]);
            }
        }
        
        return hs.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
    }
}