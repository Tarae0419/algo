import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for(int[] command : commands){
            int start = command[0] - 1;
            int end = command[1] - 1;
            int pos = command[2] - 1;
            
            int[] arr = new int[end - start + 1];
            for(int i = 0; i <= end - start; i++){
                arr[i] = array[start + i];
            }
            Arrays.sort(arr);
            answer[index++] = arr[pos];
        }
        return answer;
    }
}