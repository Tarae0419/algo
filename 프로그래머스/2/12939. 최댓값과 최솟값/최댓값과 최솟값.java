import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        int[] arr = Arrays.stream(strs)
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
        
        return arr[0] + " " + arr[arr.length - 1];
    }
}