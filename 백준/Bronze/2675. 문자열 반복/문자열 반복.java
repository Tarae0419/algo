import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            String S = sc.next();
            for(char c : S.toCharArray()){
                for(int j = 0; j < N; j++){
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}