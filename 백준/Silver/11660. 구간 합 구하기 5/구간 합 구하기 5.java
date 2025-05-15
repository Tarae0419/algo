import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] prefix = new int[N][N + 1];

        for(int i = 0; i < N; i++){
            prefix[i][0] = 0;
            for(int j = 1; j <= N; j++){
                prefix[i][j] =  prefix[i][j - 1] + sc.nextInt();
            }
        }

        while(M-- > 0){
            int x1, y1, x2, y2;
            x1 = sc.nextInt(); y1 = sc.nextInt();
            x2 = sc.nextInt(); y2 = sc.nextInt();

            int sum = 0;

            for(int i = x1; i <= x2; i++){
                sum += prefix[i - 1][y2] - prefix[i - 1][y1 - 1];
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}