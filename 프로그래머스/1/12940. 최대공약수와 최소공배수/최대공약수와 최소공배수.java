class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};
        int uc = uc(n, m);
        return new int[]{uc, (int)((long)n * m / uc)};
    }
    
    public int uc(int a, int b){
        int r = a % b;
        if(r == 0){
            return b;
        }
        return uc(b, r);
    }
}