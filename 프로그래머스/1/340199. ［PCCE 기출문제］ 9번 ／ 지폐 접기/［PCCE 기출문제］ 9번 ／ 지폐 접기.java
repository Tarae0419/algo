import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        Arrays.sort(wallet);
           
        while(true){
            Arrays.sort(bill);
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) break;
            
            answer++;
            bill[1] /= 2;
        }
        return answer;
    }
}