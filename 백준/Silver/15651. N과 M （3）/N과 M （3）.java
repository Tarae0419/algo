import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[8];

        backtracking(0);

        System.out.print(sb);
    }
    public static void backtracking(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            arr[depth] = i;
            backtracking(depth + 1);
        }
    }
}