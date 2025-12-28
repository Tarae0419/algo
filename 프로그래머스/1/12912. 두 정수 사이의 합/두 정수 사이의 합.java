class Solution {
    public long solution(int a, int b) {
        if(a == b) return a;
        
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        
        long sum = 0;
        for(long i = start; i <= end; i++){
            sum += i;
        }
        return sum;
    }
}
