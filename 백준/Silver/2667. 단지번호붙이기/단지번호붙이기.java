import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] grid;
    static int N;
    static int homeCount;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        grid = new int[N][N];
        visited = new boolean[N][N];
        int dfsCount = 0;

        for(int i = 0; i < N; i++) {
            String a = sc.next();
            for(int j = 0; j < N; j++) {
                grid[i][j] = a.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    homeCount = 0;
                    dfs(i, j);
                    dfsCount++;
                    answer.add(homeCount);
                }
            }
        }

        System.out.println(dfsCount);
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    public static void dfs(int startX, int startY){
        visited[startX][startY] = true;
        homeCount++;

        for(int i = 0; i < 4; i++){
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];

            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
                if(!visited[nextX][nextY] && grid[nextX][nextY] == 1){
                    dfs(nextX, nextY);
                }
            }
        }
    }
}