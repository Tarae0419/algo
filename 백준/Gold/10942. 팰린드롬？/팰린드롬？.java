import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[][] dp = new boolean[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < N; i++){
            if(arr[i] == arr[i + 1]){
                dp[i][i + 1] = true;
            }
        }
        for(int length = 3; length <= N; length++){
            for(int start = 1; start <= N - length + 1; start++){
                int end = start + length - 1;
                if(arr[start]  == arr[end] && dp[start + 1][end - 1]){
                    dp[start][end] = true;
                }
            }
        }

        int M = sc.nextInt();

        for(int i = 0; i < M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();

            if(dp[S][E]){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}