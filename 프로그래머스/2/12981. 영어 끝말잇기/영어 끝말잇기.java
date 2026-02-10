import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> hs = new HashSet<>();
        hs.add(words[0]);
        for(int i = 1; i < words.length; i++){
            char str1 = words[i - 1].charAt(words[i - 1].length() - 1);
            char str2 = words[i].charAt(0);
            
            if(str1 != str2) return new int[]{i % n + 1, i / n + 1};
            if(hs.add(words[i])) continue;
            else return new int[]{i % n + 1, i / n + 1};
        }
        return new int[]{0,0};
    }
}