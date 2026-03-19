import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) bridge.offer(0);
        
        int curWeight = 0, count = 0;
        for(int i = 0; i < truck_weights.length; i++){
            while(true){
                curWeight -= bridge.poll();
                
                if(curWeight + truck_weights[i] <= weight){
                    curWeight += truck_weights[i];
                    bridge.offer(truck_weights[i]);
                    count++;
                    break;
                }else{
                    bridge.offer(0);
                    count++;
                }
            }
        }
        return count + bridge_length;
    }
}