import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[][] grid = new char[N][N];

        for(int i = 0; i < N; i++){
            String s = sc.next();
            for(int j = 0; j < N; j++){
                grid[i][j] = s.charAt(j);
            }
        }

        for(int k = 0; k < 2; k++){
            visited = new boolean[N][N];
            int count = 0;

            if(k == 1 && grid[0][0] == 'G'){
                grid[0][0] = 'R';
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        bfs(i,j, N, grid, k);
                        count++;
                    }
                }
            }
            System.out.print(count + " ");
        }
    }

    public static void bfs(int startX, int startY,int N, char[][] grid, int isBlind){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curX = curNode[0];
            int curY = curNode[1];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
                    if(isBlind == 1 && grid[nextX][nextY] == 'G') {
                        grid[nextX][nextY] = 'R';
                    }
                    if(!visited[nextX][nextY] && grid[curX][curY] == grid[nextX][nextY]){
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}