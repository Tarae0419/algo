import java.util.*;

class Solution {
    public int[] solution(String s) {
        int ez = 0;
        int count = 0;
        
        while(!s.equals("1")){
            int originLength = s.length();
            
            s = s.replace("0", "");
            
            int newLength = s.length();
            
            ez += originLength - newLength;
            count++;
            
            s = Integer.toBinaryString(newLength);
        }
        return new int[]{count, ez};
    }
}