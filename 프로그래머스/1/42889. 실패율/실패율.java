import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] failRate = new double[N + 1];
        
        int curStagePlayer = stages.length;
        for(int i = 1; i < N + 1; i++){
            int notClear = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] == i) notClear++;
            }
            
            if(notClear == 0) failRate[i] = 0;
            else failRate[i] = (double)notClear /  (double)curStagePlayer;
            
            System.out.println(failRate[i]);
            curStagePlayer -= notClear;
        }
        return IntStream.range(1, N + 1)
            .boxed()
            .sorted((a, b) -> {
                int valueCompare = Double.compare(failRate[b], failRate[a]);
                if (valueCompare != 0) {
                        return valueCompare;
                    } else {
                        return Integer.compare(a,b); 
                    }
            })
            .mapToInt(i -> i)
            .toArray();
    }
}