import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int i = 1; i < N + 1; i++) {
            graph.put(i,new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i < N + 1; i++){
            Collections.sort(graph.get(i));
        }
        boolean[] visited = new boolean[graph.size() + 1];

        dfs(graph, visited, V);
        System.out.println();
        bfs(graph, V);
    }

    public static void dfs(Map<Integer,List<Integer>> graph, boolean[] visited,int start){
        visited[start] = true;
        System.out.print(start + " ");

        for(int nextNode : graph.get(start)){
            if(!visited[nextNode]){
                dfs(graph,visited,nextNode);
            }
        }
    }
    public static void bfs(Map<Integer,List<Integer>> graph,int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size() + 1];
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            System.out.print(curNode + " ");

            for(int nextNode : graph.get(curNode)){
                if(!visited[nextNode]){
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}