import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int sum = 0;
        int count = 0;
        for(int b : d){
            if(sum + b > budget) break;
            sum += b;
            count++;
        }
        return count;
    }
}