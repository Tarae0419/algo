import java.util.*;

public class Main {
    static long A,B,C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(pow(B));
    }

    public static long pow(long b){
        if(b == 1){
            return A % C;
        }
        long P = pow(b / 2);

        if(b % 2 == 0){
            return P * P % C;
        }else{
            return P * P % C * A % C;
        }
    }
}