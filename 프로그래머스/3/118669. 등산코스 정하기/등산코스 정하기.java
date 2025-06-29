import java.util.*;
class Node implements Comparable<Node>{
    int to;
    int cost;
    
    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node other){
        return this.cost - other.cost;
    }
}
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for(int[] path : paths){
            int from = path[0], to = path[1], cost = path[2];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Node(to, cost));
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Node(from, cost));
        }
        
        Set<Integer> summitSet = new HashSet<>();
        for(int summit : summits) summitSet.add(summit);
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int gate : gates){
            intensity[gate] = 0;
            pq.add(new Node(gate, 0));
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(intensity[cur.to] < cur.cost) continue;
            if(summitSet.contains(cur.to)) continue;

            for(Node next : graph.getOrDefault(cur.to, new ArrayList<>())){
                int maxCost = Math.max(intensity[cur.to], next.cost);
                if (intensity[next.to] > maxCost){
                    intensity[next.to] = maxCost;
                    pq.add(new Node(next.to, maxCost));
                }
            }
        }

        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;

        Arrays.sort(summits);
        for(int summit : summits){
            if(intensity[summit] < minIntensity){
                minIntensity = intensity[summit];
                minSummit = summit;
            }
        }

        return new int[]{minSummit, minIntensity};
    }
}