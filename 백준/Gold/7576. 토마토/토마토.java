import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int level = 0;

        int[][] grid = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int curPos = sc.nextInt();
                if(curPos == 1){
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
                grid[i][j] = curPos;
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

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if(!visited[nextX][nextY] && grid[nextX][nextY] == 0){
                        queue.add(new int[]{nextX, nextY, level + 1});
                        visited[nextX][nextY] = true;
                        grid[nextX][nextY] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(level);
    }
}