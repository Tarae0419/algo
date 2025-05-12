import java.util.*;
import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{
            if(abs(o1) == abs(o2) && o1 < o2) return -1;
            else if(abs(o1) < abs(o2)) return -1;
            else return 1;
        });

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();

            if(x == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(x);
            }
        }
    }
}