import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        Integer[] B = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        int answer = 0;
        
        for(int i = 0; i < N; i ++){
            answer += A[i] * B[i];
        }

        System.out.println(answer);
    }
}