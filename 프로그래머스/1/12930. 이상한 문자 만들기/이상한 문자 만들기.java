import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        
        int curIndex = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == ' '){
                sb.append(" ");
                curIndex = 0;
                continue;
            }
            else if(curIndex % 2 == 0) sb.append(Character.toUpperCase(ch[i]));
            else sb.append(Character.toLowerCase(ch[i]));
            curIndex++;
        }
        
        return sb.toString();
    }
}