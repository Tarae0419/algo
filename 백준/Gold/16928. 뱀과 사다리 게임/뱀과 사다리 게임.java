import java.util.*;

public class Main {
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static Map<Integer,Integer> up = new HashMap<>();;
    static Map<Integer,Integer> down = new HashMap<>();;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            up.put(x,y);
        }
        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            down.put(x,y);
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(new int[]{1,0});
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curPos = curNode[0];
            int curCount = curNode[1];

            for(int diceNum : dice){
                int nextPos = curPos + diceNum;
                nextPos = checkMove(nextPos);

                if(nextPos == 100){
                    System.out.println(curCount + 1);
                    return;
                }

                if(nextPos < 100 && !visited[nextPos]){
                    visited[nextPos] = true;
                    queue.add(new int[]{nextPos,curCount + 1});
                }
            }
        }
    }

    public static int checkMove(int num){
        for(int key : up.keySet()){
            if(num == key){
                return up.get(key);
            }
        }
        for(int key : down.keySet()){
            if(num == key){
                return down.get(key);
            }
        }
        return num;
    }
}