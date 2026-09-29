import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        while(answer.contains("..")){
            answer = answer.replace("..", ".");
        }
        
        if(answer.startsWith(".")) answer = answer.substring(1);
        if(answer.endsWith(".")) answer = answer.substring(0, answer.length() - 1);
        if(answer.length() == 0) answer = "a";
        if(answer.length() > 15) answer = answer.substring(0, 15);
        if(answer.endsWith(".")) answer = answer.substring(0, answer.length() - 1);
        if(answer.length() < 3){
            while(answer.length() < 3){
                answer += answer.substring(answer.length() - 1);
            }
        }
        
        return answer;
    }
}