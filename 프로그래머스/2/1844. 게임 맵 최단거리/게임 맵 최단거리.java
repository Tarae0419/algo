import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            int curX = curNode[0];
            int curY = curNode[1];
            int curCount = curNode[2];
            
            if(curX == maps.length - 1 && curY == maps[0].length - 1) return curCount;
            
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) continue;
                if(visited[nextX][nextY]) continue;
                if(maps[nextX][nextY] == 0) continue;
                
                queue.add(new int[]{nextX, nextY, curCount + 1});
                visited[nextX][nextY] = true;
            }
        }
        return -1;
    }
}