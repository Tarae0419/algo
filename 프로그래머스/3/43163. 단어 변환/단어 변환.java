import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> checked = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        
        queue.offer(begin);
        
        int count = 0;
        
        while(!queue.isEmpty()){    
            for(int i = 0; i < queue.size(); i++){
                String curNode = queue.poll();
                if(curNode.equals(target)) return count;
            
                for(String word : words){
                    if(check(word, curNode) && !checked.contains(word)){
                    queue.add(word);
                    checked.add(word);
                    }
                }
            }
            count++;
        }    
       return 0; 
    }
    public static boolean check(String str1, String str2){
            int diff = 0;
            for(int i = 0; i < str1.length();i++){
                if(str1.charAt(i) != str2.charAt(i)) diff++;
                if(diff > 1) return false;
            }
            return true;
        }
}