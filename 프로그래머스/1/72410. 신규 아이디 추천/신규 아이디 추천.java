import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        for(char c : answer.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c) || List.of('-','_','.').contains(c)){
                sb.append(c);    
            }
        }
        
        answer = sb.toString();
        while(answer.contains("..")){
            answer = answer.replace("..", ".");
        }
        
        if(answer.startsWith(".")){
            answer = answer.substring(1, answer.length());
        }
        if(answer.endsWith(".")){
            answer = answer.substring(0, answer.length() - 1);
        }
        
        if(answer.isEmpty()){
            answer = "a";
        }
        
        if(answer.length() > 15){
            answer = answer.substring(0,15);
            if(answer.endsWith(".")){
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        while(answer.length() < 3){
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}