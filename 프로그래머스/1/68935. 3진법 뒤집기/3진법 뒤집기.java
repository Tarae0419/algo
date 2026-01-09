import java.util.*;

class Solution {
    public int solution(int n) {
        String str = "";
        while(n != 0){
            str = (n % 3) + str;
            n /= 3;
        }
        
        int answer = 0;
        int mul = 1;
        for(char c : str.toCharArray()){
            answer += (c - '0') * mul;
            mul *= 3;
        }
        
        return answer;
    }
}