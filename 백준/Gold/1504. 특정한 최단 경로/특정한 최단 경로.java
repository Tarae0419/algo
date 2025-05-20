import java.util.*;

public class Main {
    static class Node{
        int V;
        int W;

        public Node(int v, int w){
            V = v;
            W = w;
        }
    }
    static int INF = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int ans1 = dijkstra(1, list, v1);
        ans1 += dijkstra(v1, list, v2);
        ans1 += dijkstra(v2, list, N);

        int ans2 = dijkstra(1, list, v2);
        ans2 += dijkstra(v2, list, v1);
        ans2 += dijkstra(v1, list, N);

        if(ans1 >= INF || ans2 >= INF){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(ans1, ans2));
        }
    }

    public static int dijkstra(int start, ArrayList<ArrayList<Node>> list, int end){
        boolean[] visited = new boolean[list.size()];
        int[] distance = new int[list.size()];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.W));
        pq.offer(new Node(start, 0));


        while(!pq.isEmpty()){
            Node curNode = pq.poll();

            if(visited[curNode.V]){
                continue;
            }
            visited[curNode.V] = true;

            for(Node next : list.get(curNode.V)) {
                if(distance[next.V] > distance[curNode.V] + next.W){
                    distance[next.V] = distance[curNode.V] + next.W;
                    pq.offer(new Node(next.V, distance[next.V]));
                }
            }
        }
        return distance[end];
    }
}