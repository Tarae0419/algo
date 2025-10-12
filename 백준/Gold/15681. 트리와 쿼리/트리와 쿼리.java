import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Integer>[] tree = new ArrayList[N + 1];
        List<Integer>[] child = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        makeTree(R, -1, tree, child);
        int[] size = new int[N + 1];
        countSubtreeNodes(R, child, size);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Q; i++){
            int U = Integer.parseInt(br.readLine());
            sb.append(size[U]).append("\n");
        }
        System.out.println(sb);
    }

    public static void makeTree(int currentNode, int parentNode, List<Integer>[] tree, List<Integer>[] child){
        for(int node : tree[currentNode]){
            if(node != parentNode){
                child[currentNode].add(node);
                makeTree(node, currentNode, tree, child);
            }
        }
    }

    public static void countSubtreeNodes(int currentNode, List<Integer>[] child, int[] size){
        size[currentNode] = 1;
        for(int node : child[currentNode]){
            countSubtreeNodes(node, child, size);
            size[currentNode] += size[node];
        }
    }
}
