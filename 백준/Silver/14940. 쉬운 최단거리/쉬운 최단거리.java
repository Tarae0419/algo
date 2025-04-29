import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int level = 0;
        int[][] grid = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j, level + 1});
                    visited[i][j] = true;
                    grid[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curX = curNode[0];
            int curY = curNode[1];
            level = curNode[2];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY <M){
                    if(!visited[nextX][nextY] && grid[nextX][nextY] == 1){
                        queue.add(new int[]{nextX, nextY, level + 1});
                        visited[nextX][nextY] = true;
                        grid[nextX][nextY] = level;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 1  && !visited[i][j]){
                    grid[i][j] = -1;
                }
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
}