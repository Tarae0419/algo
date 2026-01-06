class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        
        int count = 0;
        
        for(char a : arr){
            if(a == 'p' || a == 'P') count++;
            else if(a == 'y' || a == 'Y') count --;
        }
        
        answer = count == 0 ? true : false;
        
        return answer;
    }
}