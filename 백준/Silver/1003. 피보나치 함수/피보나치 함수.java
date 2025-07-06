import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            if(N == 0){
                sb.append("1 0").append("\n");
                continue;
            }
            else if(N == 1){
                sb.append("0 1").append("\n");
                continue;
            }

            int[] dp = new int[N];
            dp[0] = 1;
            dp[1] = 2;

            for(int i = 2; i < N; i++){
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            sb.append(dp[N - 1] - dp[N - 2]).append(" ").append(dp[N - 2] ).append("\n");
        }
        System.out.println(sb);
    }
}