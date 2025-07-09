import java.io.*;
import java.util.*;

class Node{
    int to;
    int cost;

    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();

        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            if (to > D) continue;
            if (to - from <= cost) continue;

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Node(to, cost));
        }

        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i <= D; i++){
            if(i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            if(graph.containsKey(i)){
                for (Node node : graph.get(i)) {
                    int dest = node.to;
                    int shortcutCost = node.cost;
                    dp[dest] = Math.min(dp[dest], dp[i] + shortcutCost);
                }
            }
        }
        System.out.println(dp[D]);
    }
}