import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{N, 0});
        visited.add(N);

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int position = curNode[0];
            int level = curNode[1];

            if(position == K){
                System.out.println(level);
                break;
            }

            int[] distance = {position - 1, position + 1, position * 2};

            for(int curDistance : distance){
                if(curDistance >= 0 && curDistance <= 100000 && !visited.contains(curDistance)){
                    visited.add(curDistance);
                    queue.add(new int[]{curDistance, level + 1});
                }
            }
        }
    }
}