import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for(int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);

            while(!stack.isEmpty() && stack.peek() == popped[popIndex]){
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}