class Solution {
    int x = 5;
    int y = 5;
    int answer = 0;
    boolean[][][] visited;
    
    public int solution(String dirs) {
        visited = new boolean[11][11][4];
        char[] chars = dirs.toCharArray();
        
        for(char ch : chars){
            if(ch == 'U') U();
            else if(ch == 'D') D();
            else if(ch == 'R') R();
            else L();
        }
        
        return answer;
    }
    
    public void U(){
        if(y != 10){
            y += 1;
            if(!visited[x][y][0] && !visited[x][y - 1][1]){
                visited[x][y][0] = true;
                answer++;
            }
        }  
    }
    
    public void D(){
        if(y != 0){
            y -= 1;
            if(!visited[x][y][1] && !visited[x][y + 1][0]){
                visited[x][y][1] = true;
                answer++;
            }
        }  
    }
    
    public void R(){
        if(x != 10){
            x += 1;
            if(!visited[x][y][2] && !visited[x - 1][y][3]){
                visited[x][y][2] = true;
                answer++;
            }
        }  
    }
    
    public void L(){
        if(x != 0){
            x -= 1;
            if(!visited[x][y][3] && !visited[x + 1][y][2]){
                visited[x][y][3] = true;
                answer++;
            }
        }  
    }
}