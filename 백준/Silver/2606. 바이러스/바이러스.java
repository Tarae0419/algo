import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int ComputerNum = sc.nextInt();
        int NetWorkNum = sc.nextInt();

        for(int i = 1; i < ComputerNum + 1; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < NetWorkNum; i++){
            int curCom = sc.nextInt();
            int nextCom = sc.nextInt();

            graph.get(curCom).add(nextCom);
            graph.get(nextCom).add(curCom);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[ComputerNum + 1];
        int count = 0;

        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            for(int nextNode : graph.get(curNode)){
                if(!visited[nextNode]){
                    queue.add(nextNode);
                    visited[nextNode] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}