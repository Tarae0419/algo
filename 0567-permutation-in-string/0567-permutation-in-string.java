class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i = s1.length(); i <= s2.length(); i++){
            int j = i - s1.length();

            char[] c1 = s1.toCharArray();
            char[] c2 = s2.substring(j, i).toCharArray();

            Arrays.sort(c1);
            Arrays.sort(c2);

            if(Arrays.equals(c1, c2)) return true;
        }
        return false;
    }
}