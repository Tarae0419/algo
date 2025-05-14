import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();

            int[][] arr = new int[2][N];
            int[][] dp = new int[2][100001];

            for(int j = 0; j < 2; j++){
                for(int k = 0; k < N; k++){
                    arr[j][k] = sc.nextInt();
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if(N > 1){
                dp[0][1] = dp[1][0] + arr[0][1];
                dp[1][1] = dp[0][0] + arr[1][1];
            }

            for(int index = 2; index < N; index++){
                dp[0][index] = Math.max(dp[1][index - 1], dp[1][index -2]) + arr[0][index];
                dp[1][index] = Math.max(dp[0][index - 1], dp[0][index -2]) + arr[1][index];
            }

            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}