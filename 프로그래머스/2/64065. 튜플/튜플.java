import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        
        String[] arr = s.split("\\},\\{");
        
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        
        Set<Integer> set = new LinkedHashSet<>();
        for(String str : arr){
            String[] elements = str.split(",");
            for(String element : elements){
                set.add(Integer.parseInt(element));
            }
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int num : set){
            answer[idx++] = num;
        }
        
        return answer;
    }
}