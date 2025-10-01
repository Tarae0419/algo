import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            arr.add(br.readLine());
        }

        char[] colors = {'W', 'B'};
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i <= N-8; i++){
            for(int j = 0; j <= M-8; j++)
            {
                int countW = 0;
                int countB = 0;
                for(int row = i; row < i + 8; row++){
                    for(int col = j; col < j + 8; col++){
                        int expectedIdx = (row + col) % 2;
                        char expectedW = colors[expectedIdx];
                        char expectedB = colors[(expectedIdx + 1) % 2];
                        char curChess = arr.get(row).charAt(col);

                        if(curChess != expectedW) countW++;
                        if(curChess != expectedB) countB++;
                    }
                }
                answer = Math.min(answer, Math.min(countW, countB));
            }
        }
        System.out.println(answer);
    }
}