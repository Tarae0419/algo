import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static int[][] chickenPos;
    static int[][] housePos;
    static int chickenIndex;
    static int houseIndex;
    static int N, M, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        map = new int[N][N];
        visited = new boolean[13];
        chickenPos = new int[13][2];
        housePos = new int[2 * N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int pos = Integer.parseInt(st.nextToken());
                map[i][j] = pos;
                if(pos == 2){
                    chickenPos[chickenIndex][0] = i;
                    chickenPos[chickenIndex++][1] = j;
                }
                if(pos == 1){
                    housePos[houseIndex][0] = i;
                    housePos[houseIndex++][1] = j;
                }

            }
        }
        bt(0,0);
        System.out.println(answer);

    }
    public static void bt(int depth, int start){
        if(depth == M){
            answer = Math.min(answer, getDistance());
            return;
        }

        for(int i = start; i < chickenIndex; i++){
            visited[i] = true;
            bt(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    public static int getDistance(){
        int sum = 0;
        for(int i = 0; i < houseIndex; i++){
            int houseX = housePos[i][0];
            int houseY = housePos[i][1];
            int minDistance = Integer.MAX_VALUE;

            for(int j = 0; j < chickenIndex; j++){
                if(visited[j]){
                    int chickenX = chickenPos[j][0];
                    int chickenY = chickenPos[j][1];
                    int distance = Math.abs(chickenX - houseX) + Math.abs(chickenY - houseY);

                    minDistance = Math.min(minDistance, distance);
                }
            }
            sum += minDistance;
        }
        return sum;
    }

}