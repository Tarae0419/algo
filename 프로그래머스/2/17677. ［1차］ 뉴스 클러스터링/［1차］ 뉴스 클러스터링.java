import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++){
            String str = str1.substring(i, i + 2);
            
            if(str.matches("^[a-z]{2}$")) str1List.add(str);
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            String str = str2.substring(i, i + 2);
            
            if(str.matches("^[a-z]{2}$")) str2List.add(str);
        }
        
        List<String> intersection = new ArrayList<>();
        
        for(String s : str1List){
            if(str2List.remove(s)) intersection.add(s);
        }
        
        int interSize = intersection.size();
        int unionSize = str1List.size() + str2List.size();
        
        double jaccard = 0;
        
        if(unionSize == 0) jaccard = 1;
        else jaccard = (double) interSize / unionSize;
        
        return (int) (jaccard * 65536);
    }
}