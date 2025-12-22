class Solution {
    public boolean solution(int x) {
        int n = x;
        int sum = 0;
        for(int i = 0; i < String.valueOf(x).length(); i++){
            sum += n % 10;
            n /= 10;
        }
        return x % sum == 0 ? true : false;
    }
}