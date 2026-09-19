import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] eg : edge) {
            int a = eg[0], b = eg[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        bfs(graph, dist);
        
        int max = 0;
        for(int i = 0; i < dist.length; i++){
            max = Math.max(max, dist[i]);
        }
        
        int answer = 0;
        for(int i = 0; i < dist.length; i++){
            if(dist[i] == max) answer++;
        }
        
        return answer;
    }
    
    public void bfs(List<List<Integer>> graph, int[] dist){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        
        while(!queue.isEmpty()){
            int curNode = queue.poll();
            
            for(int nextNode : graph.get(curNode)){
                if(dist[nextNode] == -1){
                    dist[nextNode] = dist[curNode] + 1;
                    queue.add(nextNode);
                }
            }
        }
    }
}