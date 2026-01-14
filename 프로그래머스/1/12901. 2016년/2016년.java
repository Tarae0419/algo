class Solution {
    public String solution(int a, int b) {
        int[] month = {0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        return day[(month[a] + b) % 7];
    }
}