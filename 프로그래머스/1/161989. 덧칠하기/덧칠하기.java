class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int curPos = 0;
        
        for(int sec : section){
            if(curPos < sec){
                answer++;
                curPos = sec + m - 1;
            }
        }
        return answer;
    }
}