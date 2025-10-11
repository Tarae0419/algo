import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int layer = 1;
        int end = 1;

        while(end < N){
            end += layer * 6;
            layer++;
        }
        System.out.println(layer);
    }
}
