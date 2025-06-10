import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            int a = sc.nextInt();
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