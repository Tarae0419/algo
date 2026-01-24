class Solution {
    boolean solution(String s) {
        String[] arr = s.split("");
        int sum = 0;
        for(String str : arr){
            if(str.equals("(")) sum++;
            else sum--;
            
            if(sum < 0) return false;
        }
        
        return sum == 0 ? true : false;
    }
}