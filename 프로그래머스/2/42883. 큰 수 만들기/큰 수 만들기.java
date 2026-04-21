import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        int len = number.length() - k;
        
        for (int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            
            while(k > 0 && !dq.isEmpty() && dq.peekLast() < c) {
                dq.pollLast();
                k--;
            }
            dq.addLast(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : dq){
            if(sb.length() < len){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}