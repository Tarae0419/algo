import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            int count = 0;

            graph = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                Arrays.fill(graph[i], 0);
            }

            for(int i = 0; i < K; i++){
                graph[sc.nextInt()][sc.nextInt()] = 1;
            }

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(graph[i][j] == 1 && !visited[i][j]){
                        bfs(i,j, N, M);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int x, int y, int N, int M){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curX = curNode[0];
            int curY = curNode[1];

            for(int i = 0; i < dx.length; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if(!visited[nextX][nextY] && graph[nextX][nextY] == 1){
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
