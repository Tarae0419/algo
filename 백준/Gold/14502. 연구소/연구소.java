import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSafeZone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maxSafeZone = 0;

        int[][] grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BT(0, grid);

        System.out.println(maxSafeZone);
    }

    public static void BT(int depth, int[][] grid) {
        if (depth == 3) {
            BFS(grid);
            return;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    BT(depth + 1, grid);
                    grid[i][j] = 0;
                }
            }
        }
    }

    public static void BFS(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            newGrid[i] = grid[i].clone();
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int x = curNode[0];
            int y = curNode[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
                if (newGrid[nextX][nextY] == 0) {
                    newGrid[nextX][nextY] = 2;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        int currentSafeZone = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (newGrid[i][j] == 0) currentSafeZone++;
            }
        }
        maxSafeZone = Math.max(maxSafeZone, currentSafeZone);
    }
}