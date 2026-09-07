class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int start = 0;
        int end = s1.length();
        boolean result = false;

        while(end <= s2.length()){
            char[] c2 = s2.substring(start, end).toCharArray();
            char[] c1 = s1.toCharArray();

            Arrays.sort(c1);
            Arrays.sort(c2);

            if(Arrays.equals(c1, c2)){
                result = true;
                break;
            }

            start++;
            end++;
        }

        return result;
    }
}