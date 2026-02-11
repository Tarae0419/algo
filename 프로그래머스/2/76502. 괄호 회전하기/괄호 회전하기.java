import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            s = s.substring(1, s.length()) + s.substring(0, 1);
            if(isRight(s)) count++;
        }
        
        return count;
    }
    
    public boolean isRight(String s){
        char[] chars =  s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(char ch : chars){
            if(ch == '[' || ch == '{' || ch == '(') stack.push(ch);
            else if(stack.isEmpty()) return false;
            else if(ch == ']' && stack.pop() == '[') continue;
            else if(ch == '}' && stack.pop() == '{') continue;
            else if(ch == ')' && stack.pop() == '(') continue;
            else return false;
        }
        if(stack.size() != 0) return false;
        return true;
    }
}