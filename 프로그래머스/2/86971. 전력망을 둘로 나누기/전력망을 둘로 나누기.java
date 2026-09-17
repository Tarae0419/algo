import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++){
            
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int j = 1; j <= n; j++) map.put(j, new ArrayList<>());
            
            for (int j = 0; j < wires.length; j++){
                if (j == i) continue;
                
                int from = wires[j][0];
                int to = wires[j][1];
                map.get(from).add(to);
                map.get(to).add(from);
            }

            boolean[] visited = new boolean[n + 1];
            int count = bfs(wires[i][0], visited, map);

            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    public int bfs(int start, boolean[] visited, Map<Integer, List<Integer>> map){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start] = true;
        int count = 0;
        
        while(!dq.isEmpty()){
            int curNode = dq.poll();
            count++;
            
            for(int nextNode : map.get(curNode)){
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    dq.addLast(nextNode);
                }
            }
        }
        return count;
    }
}