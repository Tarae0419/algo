import java.util.*;
class Node{
    int V;
    int W;
    
    public Node(int v, int w){
        this.V = v;
        this.W = w;
    }
}
class Solution {
    Map<Integer, List<Node>> graph = new HashMap<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Node(to, cost));
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Node(from, cost));
        }
        
        int[] distFromS = dijkstra(s, n);
        int[] distFromA = dijkstra(a, n);
        int[] distFromB = dijkstra(b, n);

        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++){
            if(distFromS[i] != Integer.MAX_VALUE &&
                distFromA[i] != Integer.MAX_VALUE &&
                distFromB[i] != Integer.MAX_VALUE){
                answer = Math.min(answer, distFromS[i] + distFromA[i] + distFromB[i]);
            }
        }

        return answer;
    }
    
    public int[] dijkstra(int start, int end){
        int[] distance = new int[end + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        Queue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.W, b.W));
        pq.add(new Node(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()){
            Node curNode = pq.remove();
            if(distance[curNode.V] < curNode.W) continue;
            
            for(Node nextNode: graph.get(curNode.V)){
                int nextW = distance[curNode.V] + nextNode.W;
                if(nextW < distance[nextNode.V]){
                    pq.add(new Node(nextNode.V, nextW));
                    distance[nextNode.V] = nextW;
                }
            }
        }
        return distance;
    }
}