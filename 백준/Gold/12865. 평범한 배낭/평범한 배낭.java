import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++){
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= K; j++){
                if(weight[i] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(value[i] + dp[i - 1][j - weight[i]], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}