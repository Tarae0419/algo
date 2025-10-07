import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if(pq.size() == 1){
            System.out.println(0);
            return;
        }

        int sum = 0;

        while(pq.size() > 1){
            int x1 = pq.poll();
            int x2 = pq.poll();

            int cost = x1 + x2;
            sum += cost;
            pq.offer(cost);
        }

        System.out.println(sum);
    }
}