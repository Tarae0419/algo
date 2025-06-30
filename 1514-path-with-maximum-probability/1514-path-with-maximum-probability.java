import java.util.*;
class Node{
    int to;
    double cost;
    
    public Node(int to, double cost){
        this.to = to;
        this. cost = cost;
    }
}
class Solution {
    Map<Integer, List<Node>> graph = new HashMap<>();
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double cost = succProb[i];

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Node(to, cost));
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Node(from, cost));
        }

        double[] distance = new double[n];
        Arrays.fill(distance, 0.0);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.cost, a.cost));
        pq.offer(new Node(start_node, 1.0));
        distance[start_node] = 1.0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            if (curNode.to == end_node) return curNode.cost;

            for(Node nextNode : graph.getOrDefault(curNode.to, Collections.emptyList())){
                double nextCost = nextNode.cost * curNode.cost;
                if(nextCost > distance[nextNode.to]){
                    pq.add(new Node(nextNode.to, nextCost));
                    distance[nextNode.to] = nextCost;
                }
            }
        }
        return 0.0;
    }
}