import java.io.*;

public class Main{
    static int S = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            String[] s = br.readLine().split(" ");
            String cmd = s[0];
            int num = 0;

            if(s.length == 2){
                num = Integer.parseInt(s[1]);
            }

            switch(cmd){
                case "add": S |= (1 << (num - 1)); break;
                case "remove": S &= ~(1 << (num - 1)); break;
                case "check": sb.append((S & (1 << (num - 1))) != 0 ? 1 : 0).append('\n'); break;
                case "toggle": S ^= (1 << (num - 1)); break;
                case "all": S = (1 << 20) - 1; break;
                case "empty": S = 0; break;
            }
        }
        System.out.print(sb);
    }
}
