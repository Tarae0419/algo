import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            set.add(a);
            arr[i] = a;
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            map.put(list.get(i), i);
        }

        for(int i = 0; i < N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}