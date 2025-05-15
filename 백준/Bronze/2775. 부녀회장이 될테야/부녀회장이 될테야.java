import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[][] dp = new int[K + 1][N + 1];

            for(int j = 1; j <= N; j++){
                dp[0][j] = j;
            }

            for(int j = 1; j <= K; j++){
                for(int k = 1; k <= N; k++){
                    if(k == 1){
                        dp[j][k] = dp[j - 1][k];
                    }else{
                        dp[j][k] = dp[j][k - 1] + dp[j - 1][k];
                    }
                }
            }
            System.out.println(dp[K][N]);
        }
    }
}