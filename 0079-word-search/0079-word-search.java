import java.util.*;

class Solution {
    int maxX, maxY;
    boolean answer;
    public boolean exist(char[][] board, String word) {
        maxX = board.length;
        maxY = board[0].length;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[maxX][maxY];
                    dfs(i, j, 0, board, word, visited);
                }
            }
        }
        return answer;
    }

    public void dfs(int x, int y, int index, char[][]board, String word, boolean[][] visited){
        if(index == word.length()){
            answer = true;
            return;
        }

        if(x < 0 || x >= maxX || y < 0 || y >= maxY) return;
        if(visited[x][y] || board[x][y] != word.charAt(index)) return;

        visited[x][y] = true;

        dfs(x - 1, y, index + 1, board, word, visited);
        dfs(x + 1, y, index + 1, board, word, visited);
        dfs(x, y - 1, index + 1, board, word, visited);
        dfs(x, y + 1, index + 1, board, word, visited);

        visited[x][y] = false;
    }
}