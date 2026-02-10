class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 1;
        
        while(true){
            a = (a - 1) / 2 + 1;
            b = (b - 1) / 2 + 1;
            
            if(a == b) return count;
            else count++;
        }
    }
}