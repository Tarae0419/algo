class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int card1 = 0;
        int card2 = 0;
        
        for(String word : goal){
            if(card1 < cards1.length && cards1[card1].equals(word)) card1++;
            else if(card2 < cards2.length && cards2[card2].equals(word)) card2++;
            else return "No";
        }
        
        return "Yes";
    }
}