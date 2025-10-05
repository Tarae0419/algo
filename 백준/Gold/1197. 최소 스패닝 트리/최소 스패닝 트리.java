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

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];

        List<Node> graph = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.add(new Node(A, B, C));
            graph.add(new Node(B, A, C));
        }

        Collections.sort(graph);

        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }

        int total = 0;
        int count = 0;

        for(Node node : graph){
            if(find(node.from) != find(node.to)){
                union(node.from, node.to);
                total += node.weight;
                count++;
                if(count == V - 1) break;
            }
        }
        System.out.println(total);
    }

    public static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if( x != y) parent[x] = y;
    }
}