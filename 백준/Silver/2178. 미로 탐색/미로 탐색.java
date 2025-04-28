import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curX = curNode[0];
            int curY = curNode[1];
            int level = curNode[2];

            if(curX == N - 1 && curY == M - 1){
                System.out.println(level);
                break;
            }

            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if(newX >= 0 && newY >= 0 && newX < N && newY < M  && grid[newX][newY] == 1 && !visited[newX][newY]){
                    queue.add(new int[]{newX, newY, level + 1});
                    visited[newX][newY] = true;
                }
            }
        }
    }
}