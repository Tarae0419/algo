import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int s = sc.nextInt();
            int target = sc.nextInt();
            boolean[] visited = new boolean[10000];
            Queue<Integer> queue = new LinkedList<>();
            Queue<String> answer = new LinkedList<>();
            queue.add(s);
            answer.add("");
            visited[s] = true;

            while(!queue.isEmpty()){
                int curNode =queue.poll();
                String path = answer.poll();

                if(curNode == target){
                    System.out.println(path);
                    break;
                }

                int nextD = D(curNode);
                int nextS = S(curNode);
                int nextL = L(curNode);
                int nextR = R(curNode);

                int[] nextNode = {nextD, nextS, nextL, nextR};
                String[] ans = {"D", "S", "L", "R"};

                for (int j = 0; j < nextNode.length; j++) {
                    int next = nextNode[j];
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        answer.add(path + ans[j]);
                    }
                }
            }
        }
    }

    public static int D(int input){
        return input * 2 % 10000;

    }
    public static int S(int input){
        if(input == 0){
            return 9999;
        }
        return input - 1;
    }public static int L(int input){
        return (input % 1000) * 10 + input / 1000;
    }
    public static int R(int input){
        return (input % 10) * 1000 + input / 10;
    }

}
