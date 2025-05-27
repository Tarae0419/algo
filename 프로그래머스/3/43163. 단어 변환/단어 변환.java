import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> checked = new HashSet<>();
        Queue<String> queue  = new ArrayDeque<>();
        queue.offer(begin);
        checked.add(begin);
        
       int count = 0;  
            
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curStr = queue.poll();
            
                if(curStr.equals(target)) return count;
            
                for(String word : words){
                    if(checkDiff(curStr, word) && !checked.contains(word)){
                        checked.add(word);
                        queue.add(word);
                    }
                }
            }
            count++;
        }
        return 0;
    }
    
    public boolean checkDiff(String str1, String str2){
        int diff = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return true;
    }
}