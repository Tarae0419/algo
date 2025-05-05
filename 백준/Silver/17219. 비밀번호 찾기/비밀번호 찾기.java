import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, String> site = new HashMap<>();

        for(int i = 1; i <= N; i++){
            site.put(sc.next(), sc.next());
        }

        for(int i = 1; i <= M; i++){
            String findKey = sc.next();
            if(site.containsKey(findKey)){
                System.out.println(site.get(findKey));
            }
        }
    }
}
