import java.util.*;

public class Main {
    static int count = 0;
    static Map<Integer,List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            graph.put(i,new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        System.out.println(count);
    }
    
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int curNode= queue.poll();

            for(int nextNode : graph.get(curNode)){
                if(!visited[nextNode]){
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
        count++;

        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
                bfs(i);
            }
        }
    }
}