import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T =sc.nextInt();

        for(int i = 0; i < T; i++){
            String s = sc.next();
            int count = 0;

            for(String str : s.split("")){
                if(str.equals("(")){
                    count++;
                }else{
                    count--;
                    if(count < 0){
                        break;
                    }
                }
            }
            if(count == 0){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}