import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> tree = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        int answer = Integer.MAX_VALUE;
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            tree.get(a).remove(Integer.valueOf(b));
            tree.get(b).remove(Integer.valueOf(a));
            
            boolean[] visited = new boolean[n + 1];
            
            int num = n - 2 * dfs(1, visited, tree);
            if(num < 0){
                answer = Math.min(answer, -num);
            }else{
                answer = Math.min(answer, num);
            }
            
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        return answer;
    }
    
    public static int dfs(int start, boolean[] visited, List<List<Integer>> tree){
        visited[start] = true;
        int count = 1;
        
        for(int nextNode : tree.get(start)){
            if(!visited[nextNode]){
                count += dfs(nextNode, visited, tree);
            }
        }
        return count;
    }
}