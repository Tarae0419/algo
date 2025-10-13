import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int from;
    int to;
    int weight;

    Node(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        List<Node> graph = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.add(new Node(from, to, weight));
        }

        Collections.sort(graph);

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        int total = 0;
        int count = 0;
        int maxWeight = 0;

        for(Node node : graph){
            if(find(node.from) != find(node.to)){
                union(node.from, node.to);
                maxWeight = Math.max(maxWeight, node.weight);
                total += node.weight;
                count++;
                if(count == N - 1) break;
            }
        }

        System.out.println(total - maxWeight);
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) parent[x] = y;
    }
}