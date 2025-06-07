class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxX = 0, maxY = 0;
        
        for(int[] size : sizes){
            int x = size[0];
            int y = size[1];
            
            if(y > x){
                int temp = x;
                x = y;
                y = temp;
            }
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        
        answer = maxX * maxY;
        return answer;
    }
}