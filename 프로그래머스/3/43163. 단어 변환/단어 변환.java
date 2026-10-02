import java.util.*;

class Solution {
    class Node{
        String word;
        int count;
        
        Node(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        Deque<Node> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        
        dq.offer(new Node(begin, 0));
        
        while(!dq.isEmpty()){
            Node node = dq.poll();
            if(node.word.equals(target)) return node.count;
            
            for(int i = 0; i < n; i++){
                if(visited[i]) continue;
                if(canChange(node.word, words[i])){
                    dq.add(new Node(words[i], node.count + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    public boolean canChange(String s1, String s2){
        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        
        return diff == 1;
    }
}