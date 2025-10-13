import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        long maxTree = 0;
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            maxTree = Math.max(maxTree, tree[i]);
        }

        long left = 0;
        long right = maxTree;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long cutLength = 0;

            for(long curTree : tree){
                if(curTree > mid){
                    cutLength += curTree - mid;
                }
            }

            if(cutLength >= M){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}