import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] point = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        double maxArea = 0;

        for(int i = 0; i < N - 2; i++){
            for(int j = i + 1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){
                    int x1 = point[i][0], y1 = point[i][1];
                    int x2 = point[j][0], y2 = point[j][1];
                    int x3 = point[k][0], y3 = point[k][1];

                    double curArea = (double) ((x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1)) / 2;
                    curArea = Math.abs(curArea);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        System.out.println(maxArea);
    }
}