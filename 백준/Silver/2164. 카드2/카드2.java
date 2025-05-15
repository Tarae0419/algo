import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }
        while(queue.size() != 1){
            queue.poll();
            int temp = queue.poll();
            queue.add(temp);
        }
        System.out.println(queue.poll());
    }
}