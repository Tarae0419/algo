import java.util.*;

public class Main {
    static int[] num;
    static int answer;
    static int N, S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        num = new int[N];

        for(int i = 0; i < N; i++){
            num[i] = sc.nextInt();
        }

        backtracking(0, 0);

        if(S == 0) answer--;
        System.out.println(answer);
    }

    public static void backtracking(int index, int sum){
        if(index == N){
            if(sum == S) answer++;
            return;
        }

        backtracking(index + 1, sum + num[index]);
        backtracking(index + 1, sum);

    }
}