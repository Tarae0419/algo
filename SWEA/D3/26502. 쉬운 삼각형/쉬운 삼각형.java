import java.util.*;
import java.io.*;

public class Solution {
	static int max;
	static int[][] coordinate;
	static int[] result = new int[3];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		while(TC-- > 0) {
			max = 0;
			
			int n = Integer.parseInt(br.readLine());
			coordinate = new int[n][2];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				coordinate[i][0] = Integer.parseInt(st.nextToken());
				coordinate[i][1] = Integer.parseInt(st.nextToken());			
			}
			
			bt(0,0);
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
    }
	
	public static void bt(int start, int depth) {
		if(depth == 3) {
			int x1 = coordinate[result[0]][0];
			int y1 = coordinate[result[0]][1];
			int x2 = coordinate[result[1]][0];
			int y2 = coordinate[result[1]][1];
			int x3 = coordinate[result[2]][0];
			int y3 = coordinate[result[2]][1];
			
	        boolean valid =
	                (x1 == x2 && y1 == y3)
	             || (x1 == x3 && y1 == y2)
	             || (x2 == x1 && y2 == y3)
	             || (x2 == x3 && y2 == y1)
	             || (x3 == x1 && y3 == y2)
	             || (x3 == x2 && y3 == y1);
	        
	        if (!valid) return;
			
			int extent = Math.abs((x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1));
			
			max = Math.max(max, extent);
			
			return;
		}
		
		for(int i = start; i < coordinate.length; i++) {
			result[depth] = i;
			
			bt(i + 1, depth + 1);
		}
	}
	
}
