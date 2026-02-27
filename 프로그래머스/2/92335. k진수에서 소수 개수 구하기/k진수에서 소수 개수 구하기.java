class Solution {
    public int solution(int n, int k) {
        String kNum = Integer.toString(n, k);
        String[] parts = kNum.split("0");
        
        int result = 0;
        
        for(String part : parts){
            if(part.equals("") || part.equals("1")) continue;
            
            if(isPrime(Long.parseLong(part))) result++;
        }
        
        return result;
    }
    
    public boolean isPrime(Long num){
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}