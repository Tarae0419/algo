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
        int E = sc.nextInt();

        ArrayList<ArrayList<Node>> list = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.get(a).add(new Node(b, c));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int answer = dijkstra(v1, list, v2);
        System.out.println(answer);
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