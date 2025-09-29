import java.io.*;
import java.util.*;

public class Main {
    static int[][] cost = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        while(true){
            int n = Integer.parseInt(st.nextToken());

            if(n == 0) break;
            arr.add(n);
        }

        int size = arr.size();
        int[][][] dp = new int[2][5][5];

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;

        for(int idx = 0; idx < size; idx++){
            int cur = idx % 2;
            int nxt = (idx + 1) % 2;
            int target = arr.get(idx);

            for(int i = 0; i < 5; i++){
                Arrays.fill(dp[nxt][i], Integer.MAX_VALUE);
            }

            for(int left = 0; left < 5; left++){
                for(int right = 0; right < 5; right++){
                    if(dp[cur][left][right] == Integer.MAX_VALUE) continue;
                    int value = dp[cur][left][right];

                    dp[nxt][target][right] = Math.min(dp[nxt][target][right], value + cost[left][target]);
                    dp[nxt][left][target] = Math.min(dp[nxt][left][target], value + cost[right][target]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        int last = size % 2;
        for(int left = 0; left < 5; left++){
            for(int right = 0; right < 5; right++){
                answer = Math.min(answer, dp[last][left][right]);
            }
        }
        
        System.out.println(answer);
    }
}