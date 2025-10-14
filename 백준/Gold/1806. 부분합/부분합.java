import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(true){
            if(sum < S){
                if(right == N) break;
                sum += arr[right];
                right++;
            }else{
                minLength = Math.min(minLength, right - left);
                sum -= arr[left];
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(minLength);
        }

    }
}