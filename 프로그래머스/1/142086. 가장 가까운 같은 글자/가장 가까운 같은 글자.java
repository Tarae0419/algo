import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        char[] strList = s.toCharArray();
        
        answer.add(-1);
        for(int i = 1; i < s.length(); i++){
            boolean isExist = false;
            for(int j = i; j > 0; j--){
                if(strList[i] == strList[j - 1]){
                    answer.add(i - j + 1);
                    isExist = true;
                    break;
                }
            } 
            if(!isExist) answer.add(-1);
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}