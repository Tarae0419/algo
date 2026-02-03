class Solution {
    public int solution(int n) {
        int targetCount = Integer.bitCount(n);
        
        while(true){
            n++;
            
            if(targetCount == Integer.bitCount(n)) return n;
        }
    }
}