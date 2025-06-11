import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N + 1][N + 1];
        int[][][] dp = new int[N + 1][N + 1][3];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if (grid[i][j] == 1) continue;

                if (j - 1 >= 1){
                    dp[i][j][0] += dp[i][j - 1][0];
                    dp[i][j][0] += dp[i][j - 1][2];
                }

                if (i - 1 >= 1){
                    dp[i][j][1] += dp[i - 1][j][1];
                    dp[i][j][1] += dp[i - 1][j][2];
                }

                if (i - 1 >= 1 && j - 1 >= 1){
                    if (grid[i - 1][j] == 0 && grid[i][j - 1] == 0){
                        dp[i][j][2] += dp[i - 1][j - 1][0];
                        dp[i][j][2] += dp[i - 1][j - 1][1];
                        dp[i][j][2] += dp[i - 1][j - 1][2];
                    }
                }
            }
        }

        int answer = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(answer);
    }
}