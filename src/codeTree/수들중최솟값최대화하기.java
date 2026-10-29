package codeTree;

import java.util.*;

public class 수들중최솟값최대화하기 {
	public class Main {
		static int n;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        int[][] grid = new int[n][n];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                grid[i][j] = sc.nextInt();
	            }
	        }
	        recursive(grid, new boolean[n][n], new int[n], 0);
	    }

		private static void recursive(int[][] grid, boolean[][] v, int[] sel, int k) {
			// basis part
			if(sel.length == k) {
				System.out.println(Arrays.toString(sel));
				return;
			}
			
			// inductive part
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!v[i][j]) {
						sel[k] = grid[i][j];
						
						for(int d = 0; d < n; d++) {
							v[i][d] = true;
							v[d][j] = true;
						}
						
						recursive(grid, v, sel, k + 1);
						
					}
					
				}
			}
			
		}

		private static boolean chk(boolean[][] v, int x , int y) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					for(int d = 0; d < n; d++) {
						if(i != x && j != y) {
							if(v[i][d] || v[d][j]) {
								return false;
							}
						}
						
					}
				}
			}
			return true;
		}
	}
}
