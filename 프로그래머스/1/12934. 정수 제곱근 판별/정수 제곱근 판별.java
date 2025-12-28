class Solution {
    public long solution(long n) {
        double answer = (long)Math.sqrt(n); 
        if(answer * answer == n) return (long) Math.pow(answer + 1,2);
        return -1;
    }
}