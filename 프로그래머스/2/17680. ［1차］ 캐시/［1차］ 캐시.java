import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int time = 0;
        Deque<String> deque = new ArrayDeque<>();
        
        for(String city : cities){
            city = city.toLowerCase();
            
            if(deque.contains(city)){
                time += 1;
                deque.remove(city);
                deque.addLast(city);
            }else{
                time += 5;
                if(cacheSize == deque.size()){
                    deque.pollFirst();
                }
                deque.addLast(city);
            }
        }
        return time;
    }
}