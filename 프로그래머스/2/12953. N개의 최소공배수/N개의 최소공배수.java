class Solution {
    public int solution(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int GCD = 0;
            int a = arr[i - 1];
            int b = arr[i];
            
            while(true){
                int n = a % b;
                if(n == 0){
                    GCD = b;
                    break;
                }else{
                    a = b;
                    b = n;
                }   
            }
            
            arr[i] = arr[i - 1] * arr[i] / GCD; 
        }
        
        return arr[arr.length - 1];
    }
}