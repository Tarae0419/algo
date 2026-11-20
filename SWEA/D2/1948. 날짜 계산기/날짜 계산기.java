import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] daysSum = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sb.append("#").append(i + 1).append(" ");
			
			int month1 = Integer.parseInt(st.nextToken());
			int day1 = Integer.parseInt(st.nextToken());
			int month2 = Integer.parseInt(st.nextToken());
			int day2 = Integer.parseInt(st.nextToken());
			
			int culDay = (daysSum[month2 - 1] + day2) - (daysSum[month1 - 1]  + day1) + 1;
			
			sb.append(culDay).append("\n");
		}
		
		System.out.print(sb);
    }
}
