import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            Deque<Integer> deque = new ArrayDeque<>();

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            boolean isReversed = false;
            boolean isError = false;

            String str = br.readLine();
            str = str.replaceAll("[\\[\\]]", "");
            String[] nums = str.split(",");

            if (!str.isEmpty()) {
                for (String num : nums) {
                    deque.offer(Integer.parseInt(num));
                }
            }

            for(int k = 0; k < p.length(); k++){
                if(p.charAt(k) == 'R') {
                    isReversed = !isReversed;
                }else if(p.charAt(k) == 'D'){
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }
                    if(isReversed) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            if(isError) {
                sb.append("error\n");
                continue;
            }
            sb.append("[");
            if (!deque.isEmpty()) {
                if (isReversed) {
                    while (deque.size() > 1)
                        sb.append(deque.pollLast()).append(",");
                    sb.append(deque.pollLast());
                } else {
                    while (deque.size() > 1)
                        sb.append(deque.pollFirst()).append(",");
                    sb.append(deque.pollFirst());
                }
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}