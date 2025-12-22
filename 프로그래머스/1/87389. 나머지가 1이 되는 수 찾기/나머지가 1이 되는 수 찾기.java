import java.util.*;
    
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] array = new boolean[n + 1];
        Arrays.fill(array, true);
        
        for(int i = 2; i < Math.sqrt(n) + 1; i++){
            if(array[i]){
                int j = 2;
                while(i * j <= n){
                    array[i * j] = false;
                    j += 1;
                }
            }
        }
        
        for(int i = 2; i < n + 1; i++){
            if(array[i] && (n % i == 1)){
                return i;
            }
        }
        return -1;
    }
}