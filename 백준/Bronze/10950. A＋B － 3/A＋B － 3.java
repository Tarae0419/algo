import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int sum = sc.nextInt() + sc.nextInt();
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}