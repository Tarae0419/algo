import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    String[] w = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word) + 1;
    }
    
    public void dfs(String str, int depth){
        if (str.length() > 0) list.add(str);
        
        if (depth == 5) return;
        
        for(int i = 0; i < 5; i++){
            dfs(str + w[i], depth + 1);
        }
    }
}