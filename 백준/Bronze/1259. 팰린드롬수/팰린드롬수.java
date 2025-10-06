import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while(true){
            int num = Integer.parseInt(br.readLine());

            if( num == 0) break;

            String numStr = String.valueOf(num);

            int start = 0, end = numStr.length() - 1;
            boolean isTrue = true;
            while(start < end){
                if(numStr.charAt(start) == numStr.charAt(end)){
                    start++;
                    end--;
                }else{
                    isTrue = false;
                    break;
                }
            }
            if(isTrue) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}