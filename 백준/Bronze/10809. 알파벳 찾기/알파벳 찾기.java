import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int[] arr = new int[26];

        Arrays.fill(arr,-1);

        for(int i = 0; i <s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(arr[index] == -1){
                arr[index] = i;
            }
        }

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}