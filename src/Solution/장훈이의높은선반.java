package Solution;

import java.io.*;
import java.util.*;

public class 장훈이의높은선반 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for(int t = 1; t<= tc; t++) {
			int n, b;
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			str = bf.readLine();
			st = new StringTokenizer(str);
			for(int i = 0; i< n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			
			
			recursive(0, 0, arr, n, b);
			
			System.out.println("#" + t + " " + (min-b));
		}
		
	}
	
	static int min;
	
	
	private static void recursive(int k, int sum, int[] arr, int n, int b) {
		// basis
		if(sum >= b) {
			min = Math.min(sum, min);
			return;
		}
		if(k == n) {
			return;
		}
		
		// inductive
		
		recursive(k+1, sum, arr, n, b);
		
		sum = sum + arr[k];
		recursive(k+1, sum, arr, n, b);
		
	}
}
