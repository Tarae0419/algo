import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            set.add(sc.nextInt());
        }

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        for(int num : sortedList){
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

}