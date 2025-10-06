import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        int minSum = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        for(int i = 0; i < N - 1; i++){
            int currentSum = arr[start] + arr[end];

            if(Math.abs(minSum) >= Math.abs(currentSum)){
                minStart = start;
                minEnd = end;
                minSum = currentSum;
            }

            if(currentSum < 0){
                start++;
            }else if(currentSum > 0){
                end--;
            }else{
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[minStart]).append(" ").append(arr[minEnd]);
        System.out.println(sb);
    }
}