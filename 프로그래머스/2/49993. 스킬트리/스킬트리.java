class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skillTree : skill_trees){
            String str = "";
            
            for(int i = 0; i < skillTree.length(); i++){
                char ch = skillTree.charAt(i);
                if(skill.indexOf(ch) != -1) str += ch;
            }
            if(skill.startsWith(str)) answer++;
        }
        
        return answer;
    }
}