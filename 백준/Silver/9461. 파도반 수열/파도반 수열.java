import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int j = 0; j < T; j++){
            int N = sc.nextInt();
            long[] dp = new long[101];

            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;

            for(int i = 3; i < N; i++){
                dp[i] = dp[i - 3] + dp[i - 2];
            }

            System.out.println(dp[N - 1]);
        }
    }
}