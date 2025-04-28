import java.util.*;

public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

         grid = new int[N][M];
         visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && grid[i][j] != 0){
                    if (bfs(i, j)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }
    public static boolean bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        boolean isTop = true;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curX = curNode[0];
            int curY = curNode[1];

            for(int i = 0; i < 8; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if (grid[newX][newY] > grid[curX][curY]) {
                        isTop = false;
                    }
                    if(!visited[newX][newY] && grid[newX][newY] == grid[curX][curY]){
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return isTop;
    }
}