import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Map<String, String> dogamInt = new HashMap();
        Map<String, String> dogamString = new HashMap();

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 1; i <= N; i++){
            String s = sc.next();
            dogamInt.put(s, Integer.toString(i));
            dogamString.put(Integer.toString(i), s);
        }

        for(int i = 0; i < M; i++){
            String s = sc.next();
            if(dogamInt.containsKey(s)){
                System.out.println(dogamInt.get(s));
            }else{
                System.out.println(dogamString.get(s));
            }
        }
    }
}
