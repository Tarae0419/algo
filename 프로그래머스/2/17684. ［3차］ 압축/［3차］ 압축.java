import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= 26; i++){
            map.put(String.valueOf((char)('A' + i - 1)), i);
        }
        
        List<Integer> result = new ArrayList<>();
        int addWord = 27;
        
        String str = "";
        
        for(int i = 0; i < msg.length(); i++){
            char ch = msg.charAt(i);
            str += ch;
            
            if(i + 1 < msg.length()){
                String nextStr = str + msg.charAt(i + 1);
                if(!map.containsKey(nextStr)){
                    map.put(nextStr, addWord++);
                    result.add(map.get(str));
                    str = "";
                }
            }else result.add(map.get(str));
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}