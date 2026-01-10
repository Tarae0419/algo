class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c == ' ') answer += " ";
            else if( c >= 'A' && c <= 'Z'){
                if(c + n > 'Z') answer += (char)(c + n - 26);
                else answer += (char)(c + n);
            }
            else{
                if(c + n > 'z') answer += (char)(c + n - 26);
                else answer += (char)(c + n); 
            }
        }
        return answer;
    }
}