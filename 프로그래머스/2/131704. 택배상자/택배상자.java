import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> dq = new ArrayDeque<>();
        int cur = 1;
        int cnt = 0;
        
        for(int want : order){
            while(cur < want){
                dq.push(cur);
                cur++;
            }
            
            if(cur == want){
                cnt++;
                cur++;
            }  
            else if(!dq.isEmpty() && dq.peek() == want){
                dq.pop();
                cnt++;
            }
            else break;
        }
        
        return cnt;
    }
}