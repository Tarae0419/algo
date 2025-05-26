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
    static int INF = 100000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        ArrayList<ArrayList<Node>> list = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.get(a).add(new Node(b,c));
        }

        int ans = 0;
        int[] distance = new int[N + 1];
        for(int i = 1; i <= N; i++){
            int a = dijkstra(i, X, list);
            int b = dijkstra(X, i, list);

            distance[i] = a + b;
            ans = Math.max(distance[i], ans);
        }
        System.out.println(ans);
    }

    public static int dijkstra(int start, int end, ArrayList<ArrayList<Node>> list){
        boolean[] visited = new boolean[list.size()];
        int[] distance = new int[list.size()];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.W));
        pq.add(new Node(start, 0));

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