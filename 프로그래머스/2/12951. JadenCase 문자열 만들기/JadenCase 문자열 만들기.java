class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        
        String[] words = s.toLowerCase().split("");
        
        for(String word : words){
            if(word.equals(" ")){
                sb.append(" ");
                isFirst = true;
            }else{
                if(isFirst){
                    sb.append(word.toUpperCase());
                    isFirst = false;
                } else{
                    sb.append(word);
                }
            }        
        }
        return sb.toString();
    }
}