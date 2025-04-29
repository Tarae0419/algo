import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();
        int level = 0;

        int[][][] grid = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    grid[i][j][k] = sc.nextInt();
                    if(grid[i][j][k] == 1){
                        queue.add(new int[]{i, j, k, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curZ = curNode[0];
            int curY = curNode[1];
            int curX = curNode[2];
            int curLevel = curNode[3];

            level = Math.max(level, curLevel);

            for(int i = 0; i < 6; i++){
                int nextZ = curZ + dh[i];
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if(nextZ >= 0 && nextZ < H && nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    if(grid[nextZ][nextY][nextX] == 0 && !visited[nextZ][nextY][nextX]){
                        queue.add(new int[]{nextZ, nextY, nextX, curLevel + 1});
                        visited[nextZ][nextY][nextX] = true;
                        grid[nextZ][nextY][nextX] = 1;
                    }
                }
            }
        }

        for(int i = 0 ; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(grid[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(level);
    }
}