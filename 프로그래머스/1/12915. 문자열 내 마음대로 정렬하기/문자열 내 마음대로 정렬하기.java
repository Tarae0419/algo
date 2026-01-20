import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Map<Character, TreeSet<String>> map = new TreeMap<>();
        
        for(String str : strings){
            char key = str.charAt(n);
            
            map.computeIfAbsent(key, k -> new TreeSet<>()).add(str);
        }
        
        return map.values().stream()
            .flatMap(Collection::stream)
            .toArray(String[]::new);
    }
}