class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        String[] repeatWords = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for (String str : babbling) {
            boolean isRepeat = false;
            
            for (String repeat : repeatWords) {
                if (str.contains(repeat)) {
                    isRepeat = true;
                    break;
                }
            }
            if (isRepeat) continue;

            for (String word : words) {
                str = str.replace(word, " "); 
            }

            if (str.replace(" ", "").length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}