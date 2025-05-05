import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> notHeard = new HashSet<>();
        Set<String> notSeen = new HashSet<>();

        for(int i = 0; i < N; i++){
            notHeard.add(sc.next());
        }

        for(int i = 0; i < M; i++){
            notSeen.add(sc.next());
        }

        notHeard.retainAll(notSeen);

        List<String> Arr = new ArrayList<>(notHeard);
        Collections.sort(Arr);

        System.out.println(Arr.size());
        for(String s : Arr){
            System.out.println(s);
        }
    }
}
