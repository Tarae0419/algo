import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[C + 101];
        Arrays.fill(arr, 100000000);
        arr[0] = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            arr[customer] = Math.min(arr[customer], cost);

            for(int j = customer; j <= C + 100; j++){
                arr[j] = Math.min(arr[j], arr[j - customer] + cost);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = C; j <= C + 100; j++) {
            ans = Math.min(ans, arr[j]);
        }
        System.out.println(ans);
    }
}