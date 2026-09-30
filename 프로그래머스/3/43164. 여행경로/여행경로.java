import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> path = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {

        for(String[] ticket : tickets){
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        dfs("ICN");
        return path.toArray(new String[0]);
    }
    
    public void dfs(String cur){
        PriorityQueue<String> pq = graph.get(cur);
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        path.addFirst(cur);
    }
}