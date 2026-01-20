class Solution {
    public String solution(int[] food) {
        String str1 = "";
        String str2 = "";
        
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i] / 2; j++){
                str1 = str1 + i;
                str2 = i + str2;
            }
        }
        return str1 + "0" + str2;
    }
}