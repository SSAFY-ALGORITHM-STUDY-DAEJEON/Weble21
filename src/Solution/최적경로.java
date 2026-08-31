<<<<<<< HEAD
package Solution;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최적경로 {
	static int min;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			min = 2100000000;
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int[] work = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			
			int[][] arr = new int[n][2];
			for(int i =0; i < n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] v = new boolean[n];
			
			
			dfs(work, home, arr, v, 0, new int[n][2]);
			System.out.println("#" + t + " " + min);
		}

		
	}
	
	static void dfs(int[] work, int[] home, int[][] arr, boolean[] v, int k, int[][] sel) {
	
		if (k == arr.length) {
			int res = calculate(work, home, sel);
			//System.out.println(Arrays.deepToString(sel));
			//System.out.println(res);
			if(min > res) min = res;
			return;
		}
		for(int i = 0; i<arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				dfs(work, home, arr, v, k+1, sel);
				v[i] = false;
			}
		}		
		
	}
	
	static int calculate(int[]work, int[] home, int[][] sel) {
		int sum = 0;
		sum = sum + Math.abs(sel[0][0] - work[0]) + Math.abs(sel[0][1] - work[1]);
		
		for(int i = 0; i<sel.length-1; i++) {
			sum = sum + Math.abs(sel[i][0] - sel[i+1][0]) + Math.abs(sel[i][1] - sel[i+1][1]);
		}
		
		sum = sum + Math.abs(sel[sel.length-1][0] - home[0]) + Math.abs(sel[sel.length-1][1] - home[1]);
		
		return sum;
	}
	

}
=======
package Solution;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최적경로 {
	static int min;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			min = 2100000000;
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int[] work = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			
			int[][] arr = new int[n][2];
			for(int i =0; i < n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] v = new boolean[n];
			
			
			dfs(work, home, arr, v, 0, new int[n][2]);
			System.out.println("#" + t + " " + min);
		}

		
	}
	
	static void dfs(int[] work, int[] home, int[][] arr, boolean[] v, int k, int[][] sel) {
	
		if (k == arr.length) {
			int res = calculate(work, home, sel);
			//System.out.println(Arrays.deepToString(sel));
			//System.out.println(res);
			if(min > res) min = res;
			return;
		}
		for(int i = 0; i<arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				dfs(work, home, arr, v, k+1, sel);
				v[i] = false;
			}
		}		
		
	}
	
	static int calculate(int[]work, int[] home, int[][] sel) {
		int sum = 0;
		sum = sum + Math.abs(sel[0][0] - work[0]) + Math.abs(sel[0][1] - work[1]);
		
		for(int i = 0; i<sel.length-1; i++) {
			sum = sum + Math.abs(sel[i][0] - sel[i+1][0]) + Math.abs(sel[i][1] - sel[i+1][1]);
		}
		
		sum = sum + Math.abs(sel[sel.length-1][0] - home[0]) + Math.abs(sel[sel.length-1][1] - home[1]);
		
		return sum;
	}
	

}
>>>>>>> 6d3dbf7 (활주로 문제)
