import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] prefix = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + sc.nextInt();
        }

        for (int q = 0; q < M; q++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(prefix[j] - prefix[i - 1]);
        }
    }
}
