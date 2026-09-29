class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
        for(int t : times) max = Math.max(max, t);
        return needTime(1, max * n, times, n);
    }
    
    public long needTime(long first, long end,int[] times, long n){
        if(first >= end) return first;

        long mid = first + (end - first) / 2;
        long total = 0;
        
        for(int time : times){
            total += mid / time;
            if (total >= n) break;
        }

        if(total >= n) return needTime(first, mid, times, n);
        else return needTime(mid + 1, end, times, n); 
    }
}