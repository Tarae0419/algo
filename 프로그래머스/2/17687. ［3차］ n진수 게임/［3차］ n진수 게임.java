import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder allChars = new StringBuilder();
        int num = 0;
        
        while(allChars.length() < t * m){
            allChars.append(Integer.toString(num++, n).toUpperCase());
        }
        
        for(int i = 0; i < t; i++){
            answer.append(allChars.charAt((p - 1) + (i * m)));
        }
        
        return answer.toString();
    }
}