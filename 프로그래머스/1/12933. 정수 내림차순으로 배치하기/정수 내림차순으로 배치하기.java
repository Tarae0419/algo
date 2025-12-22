import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        
        Arrays.sort(chars);
        
        StringBuilder sb = new StringBuilder(new String(chars));
        String stringAnswer = sb.reverse().toString();
        
        Long answer = Long.parseLong(stringAnswer);
        return answer;
    }
}