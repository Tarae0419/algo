import javax.lang.model.type.ArrayType;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < N - 1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];

        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            for(int nextNode : map.get(curNode)){
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    parent[nextNode] = curNode;
                    queue.add(nextNode);
                }
            }
        }
        
        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }
}