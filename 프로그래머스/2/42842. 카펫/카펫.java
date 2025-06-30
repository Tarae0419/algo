class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        for(int height = 3; height <= total / height; height++){
            int width = total / height;
            
            if((height - 2) * (width - 2) == yellow) return new int[]{width, height};
        }
        return null;
    }
}