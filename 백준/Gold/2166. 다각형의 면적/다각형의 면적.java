import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] point = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        long area = 0;
        int sumX = 0, sumY = 0;
        int subX = 0, subY = 0;

        for(int i = 0; i < N; i++){
            if(i == N - 1){
                sumX = point[i][0];
                sumY = point[0][1];
                subX = point[0][0];
                subY = point[i][1];
            } else{
                sumX = point[i][0];
                sumY = point[i + 1][1];
                subX = point[i + 1][0];
                subY = point[i][1];
            }

            area += (long) sumX * sumY - (long) subX * subY;
        }

        double answer = Math.abs(area) / 2.0;
        System.out.printf("%.1f\n", answer);
    }
}