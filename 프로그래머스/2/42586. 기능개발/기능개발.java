import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int prev = 0;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){ 
            int remain = 100 - progresses[i];
            int cur = (remain + speeds[i] - 1) / speeds[i];
            
                if (i == 0){
                prev = cur;
                cnt = 1;
                continue;
            }
            
            if(cur <= prev) cnt++;
            else{
                list.add(cnt);
                cnt = 1;
                prev = cur;
            }
        }
        list.add(cnt);
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}