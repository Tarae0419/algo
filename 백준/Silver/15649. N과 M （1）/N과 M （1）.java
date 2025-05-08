import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[N + 1];

        dfs(0);
    }
    public static void dfs(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}