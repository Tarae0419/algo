import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] curMax  = new int[3];
        int[] curMin  = new int[3];
        int[] prevMax = new int[3];
        int[] prevMin = new int[3];

        prevMax[0] = arr[0][0]; prevMax[1] = arr[0][1]; prevMax[2] = arr[0][2];
        prevMin[0] = arr[0][0]; prevMin[1] = arr[0][1]; prevMin[2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            int a = arr[i][0], b = arr[i][1], c = arr[i][2];

            int p0 = prevMax[0], p1 = prevMax[1], p2 = prevMax[2];
            int q0 = prevMin[0], q1 = prevMin[1], q2 = prevMin[2];

            curMax[0] = Math.max(p0, p1) + a;
            curMax[1] = Math.max(Math.max(p0, p1), p2) + b;
            curMax[2] = Math.max(p1, p2) + c;

            curMin[0] = Math.min(q0, q1) + a;
            curMin[1] = Math.min(Math.min(q0, q1), q2) + b;
            curMin[2] = Math.min(q1, q2) + c;

            System.arraycopy(curMax, 0, prevMax, 0, 3);
            System.arraycopy(curMin, 0, prevMin, 0, 3);
        }

        int maxAns = Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]);
        int minAns = Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]);

        System.out.println(maxAns + " " + minAns);
    }
}