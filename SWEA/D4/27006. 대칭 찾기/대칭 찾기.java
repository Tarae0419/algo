import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine().trim());

            char[][] board = new char[n][n];

            for (int row = 0; row < n; row++) {
                board[row] = br.readLine().trim().toCharArray();
            }

            int answer = 0;

            for (int a = 0; a < n; a++) {
                boolean symmetric = true;

                for (int row = 0; row < n; row++) {
                    for (int col = row + 1; col < n; col++) {

                        char first = board[(row + a) % n][col];
                        char second = board[(col + a) % n][row];

                        if (first != second) {
                            symmetric = false;
                            break;
                        }
                    }

                    if (!symmetric) {
                        break;
                    }
                }

                if (symmetric) {
                    answer += n;
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
	
}
