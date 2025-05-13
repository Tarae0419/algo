import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] triangle = new int[N][N];
        int[][] dp = new int[501][501];

        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                triangle[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = triangle[0][0];

        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][0] + triangle[i][0];
                }else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for(int j = 0; j < N; j++){
            answer = Math.max(answer, dp[N - 1][j]);
        }
        System.out.println(answer);
    }
}