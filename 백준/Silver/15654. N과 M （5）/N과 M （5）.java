import java.util.*;

public class Main {
    static int N, M;
    static int arr[];
    static boolean[] visited;
    static int[] num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[10001];
        num = new int[N];

        for(int i = 0; i < N; i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);

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

        for (int i = 0; i < N; i++){
            if(!visited[num[i]]){
                visited[num[i]] = true;
                arr[depth] = num[i];
                dfs(depth + 1);
                visited[num[i]] = false;
            }
        }
    }
}