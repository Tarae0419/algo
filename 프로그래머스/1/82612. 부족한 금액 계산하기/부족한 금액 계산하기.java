class Solution {
    public long solution(int price, int money, int count) {
        long s = 0;
        
        for(int i = 1; i <= count; i++){
            s += price * i;
        }
        
        return money - s > 0 ? 0 : -(money - s);
    }
}