class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        bt(dungeons, k, visited, 0);
        return answer;
    }
    
    public void bt(int[][] dungeons, int k, boolean[] visited, int count){
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            int require = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(k >= require){
                visited[i] = true;
                bt(dungeons, k - cost, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}