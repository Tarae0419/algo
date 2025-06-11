import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int blue, white;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DC(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void DC(int N, int x, int y){
        int color = grid[x][y];
        for (int i = x; i < x + N; i++){
            for (int j = y; j < y + N; j++){
                if (grid[i][j] != color){
                    int div = N / 2;
                    DC(div, x, y);
                    DC(div, x + div, y);
                    DC(div, x, y + div);
                    DC(div, x + div, y + div);
                    return;
                }
            }
        }
        if (color == 0) white++;
        else blue++;
    }

}