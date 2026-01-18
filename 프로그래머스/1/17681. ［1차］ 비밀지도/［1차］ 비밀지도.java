class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String or = Integer.toString((arr1[i] | arr2[i]), 2);
            or = String.format("%" + n + "s", or).replace(' ', '0');
            answer[i] = or.replace("1", "#").replace("0", " ");
        }
        
        return answer;
    }
}