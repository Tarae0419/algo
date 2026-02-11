import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int low = 0;
        int high = citations.length - 1;
        int hIndex = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            int midNum = citations[mid];

            if(citations.length - mid <= midNum){
                hIndex = citations.length - mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        
        return hIndex;
    }
}