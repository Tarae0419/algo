import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextInt();
        long B = sc.nextInt();

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{A, 0});

        while(!queue.isEmpty()){
            long[] curNums = queue.poll();
            long curNum = curNums[0];
            long curCount = curNums[1];

            if(curNum == B){
                System.out.println(curCount + 1);
                return;
            }
            if(curNum > B){
                continue;
            }

            long numA = curNum * 2;
            queue.add(new long[]{numA, curCount + 1});

            String s = curNum + "1";
            long numB = Long.parseLong(s);
            queue.add(new long[]{numB, curCount + 1});

        }
        System.out.println(-1);
    }
}