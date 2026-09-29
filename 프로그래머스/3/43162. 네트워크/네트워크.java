import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1) list.get(i).add(j);       
            }
        }
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            
            BFS(i, list, visited);
            answer++;
        }
        
        return answer;
    }
    
    public void BFS(int start, List<List<Integer>> list, boolean[] visited){
        Deque<Integer> dq = new ArrayDeque<>();
        visited[start] = true;
        dq.offer(start);
        
        while(!dq.isEmpty()){
            int curNode = dq.poll();
            
            for(int nextNode : list.get(curNode)){
                if(visited[nextNode]) continue;
                
                dq.offer(nextNode);
                visited[nextNode] = true;
            }
        }
    }
}