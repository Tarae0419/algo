import java.io.*;
import java.util.*;

public class Main {
    static int[] cycle;
    static boolean[] visited;
    static boolean[] finished;
    static int studentCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int studentNum = Integer.parseInt(br.readLine());

            cycle = new int[studentNum + 1];
            visited = new boolean[studentNum + 1];
            finished = new boolean[studentNum + 1];
            studentCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < studentNum + 1; j++){
                cycle[j] = Integer.parseInt(st.nextToken());
            }
            for(int k = 1; k < studentNum + 1; k++){
                if(visited[k]) continue;
                DFS(k);
            }

            System.out.println(studentNum - studentCount);
        }
    }

    public static void DFS(int x){
        visited[x] = true;
        int next = cycle[x];

        if(!visited[next]){
            DFS(next);
        }else if(!finished[next]){
            int current = next;
            while(current != x){
                studentCount++;
                current = cycle[current];
            }
            studentCount++;
        }
        finished[x] = true;
    }
}