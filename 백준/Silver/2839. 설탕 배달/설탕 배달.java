import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] bags = new int[] {3, 5};
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        Arrays.fill(dp, 100000);
        dp[0] = 0;

        for (int i = 0; i < bags.length; i++) {
            for (int j = bags[i]; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j - bags[i]] + 1);
            }
        }

        if(dp[N] == 100000){
            System.out.println(-1);
        }else{
            System.out.println(dp[N]);
        }
    }
}
