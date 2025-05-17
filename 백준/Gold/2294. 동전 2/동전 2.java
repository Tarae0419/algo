import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[K + 1];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int coin : arr){
            for(int i = coin; i <= K; i++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if(dp[K] == 10001){
            System.out.println(-1);
        }else{
            System.out.println(dp[K]);
        }
    }
}