import java.util.*;

public class Main {
    static int[] arr;
    static int[] num;
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        num = new int[N];
        arr = new int[M];

        for(int i = 0; i < N; i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);

        backtracking(0, 0);
    }
    public static void backtracking(int depth, int start){
        if(depth == M){
            for(int i = 0; i < M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for(int i = start; i < N; i++){
            if(prev == num[i]) continue;

            arr[depth] = num[i];
            prev = num[i];
            backtracking(depth + 1, i);
        }
    }
}