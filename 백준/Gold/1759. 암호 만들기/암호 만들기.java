import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        char[] list = new char[C];

        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);
        char[] ch = new char[L];
        BT(0, 0, 0, 0, ch, list, L, C);

    }
    public static void BT(int depth, int start, int consonants, int vowels, char[] ch, char[] list, int L, int C){
        if(depth == L){
            if(vowels < 1 || consonants < 2) return;
            StringBuilder str = new StringBuilder();
            for(char c : ch){
                str.append(c);
            }
            System.out.println(str);
            return;
        }

        for(int i = start; i < C; i++){
            ch[depth] = list[i];
            if("aeiou".indexOf(list[i]) != -1){
                BT(depth + 1, i + 1, consonants, vowels + 1, ch, list, L, C);
            } else {
                BT(depth + 1, i + 1, consonants + 1, vowels, ch, list, L, C);
            }
        }
    }
}