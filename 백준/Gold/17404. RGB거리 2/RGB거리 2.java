import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 1000000;
        int N = sc.nextInt();

        int[][] cost = new int[N + 1][3];
        for(int i = 1; i <= N; i++){
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        for(int first = 0; first < 3; first++){
            int[][] dp = new int[N + 1][3];

            for(int j = 0; j < 3; j++){
                if(j == first){
                    dp[1][j] = cost[1][j];
                }
                else{
                    dp[1][j] = 1000000;
                }
            }

            for(int i = 2; i <= N; i++){
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for(int i = 0; i < 3; i++){
                if(first != i){
                    answer = Math.min(answer, dp[N][i]);
                }
            }
        }
        System.out.println(answer);
    }
}