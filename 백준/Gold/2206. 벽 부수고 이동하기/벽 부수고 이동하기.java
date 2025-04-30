import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextShort();
        int M = sc.nextShort();

        int[][] grid = new int[N][M];

        for(int i = 0; i < N; i++){
            String s = sc.next();
            for(int j = 0; j < M; j++){
                grid[i][j] = s.charAt(j) - '0';
            }
        }

        final int[] dx = {-1, 1, 0, 0};
        final int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        queue.add(new int[]{0,0,1,0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curX = curNode[0];
            int curY = curNode[1];
            int level = curNode[2];
            int isBreak = curNode[3];

            if(curX == N - 1 && curY == M - 1){
                System.out.println(level);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M){
                    if(grid[nextX][nextY] == 0 && !visited[nextX][nextY][isBreak]){
                        visited[nextX][nextY][isBreak] = true;
                        queue.add(new int[]{nextX, nextY, level + 1, isBreak});
                    }
                    else if(grid[nextX][nextY] == 1 && isBreak == 0 && !visited[nextX][nextY][1]){
                        visited[nextX][nextY][1] = true;
                        queue.add(new int[]{nextX, nextY, level + 1, 1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}