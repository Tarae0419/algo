import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int meetCount = 0;
        int startX = 0, startY = 0;

        char[][] grid = new char[N][M];

        for(int i = 0; i < N; i++){
            String s = sc.next();
            for(int j = 0; j < M; j++){
                char c = s.charAt(j);
                grid[i][j] = c;
                if(grid[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];
        queue.add(new int[]{startX,startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curX = curNode[0];
            int curY = curNode[1];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M){
                    if(!visited[nextX][nextY] && grid[nextX][nextY] != 'X'){
                        if(grid[nextX][nextY] == 'P'){
                            meetCount += 1;
                        }
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        if(meetCount == 0){
            System.out.println("TT");
        }else{
            System.out.println(meetCount);
        }
    }
}