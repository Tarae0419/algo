import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		int[] nArray = new int[TC];
		int max = 0;
		
		for(int i = 0; i < TC; i++) {
			int n = Integer.parseInt(br.readLine());
			max = Math.max(max, n);
			nArray[i] = n;
		}
		
		int[] na = new int[max + 1];
		
		na[0] = 1;
		na[1] = 1;
		
		for(int i = 2; i <= max; i++) {
			int candidate = 1;
			
			while(true) {
				boolean possible = true;
				
				for(int k = 1; k <= i / 2; k++) {
					if(candidate - na[i - k] == na[i - k] - na[i - 2 * k]) {
						possible = false;
						break;
					}
				}
				
				if(possible) {
					na[i] = candidate;
					break;
				}
				
				candidate++;
			}
		}
		
		for (int n : nArray) {
		    sb.append(na[n]).append('\n');
		}

		System.out.print(sb);
		
    }
	
}
