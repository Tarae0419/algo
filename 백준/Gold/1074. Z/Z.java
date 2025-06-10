import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sb.append(DC(N, S, C));
        System.out.println(sb);
    }

    public static int DC(int N, int x, int y){
        if(N == 0) return 0;

        int half = 1 << (N - 1);
        int size = half * half;

        if (x < half && y < half) return  DC(N - 1, x, y);
        if (x < half && y >= half) return size + DC(N - 1, x, y - half);
        if (x >= half && y < half) return 2 * size + DC(N - 1, x - half, y);
        return 3 * size + DC(N - 1, x - half, y - half);
    }
}