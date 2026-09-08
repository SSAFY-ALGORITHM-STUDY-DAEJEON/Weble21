package codeTree;

import java.util.*;

public class 코드트리_수들의합최대화하기 {
	static int n;
	static int max = 0;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] grid = new int[n][n];
		v = new boolean[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		recursive(grid, 0, 0);
		System.out.println(max);
	}

	private static void recursive(int[][] grid, int row, int sum) {
		// basis part
		if (row == n) {
			System.out.println(max);
			max = Math.max(max, sum);
			return;
		}

		// inductive part
		for (int i = 0; i < n; i++) {
			if(!v[i]) {
				v[i] = true;
				recursive(grid, row+1, sum+grid[row][i]);
				v[i] = false;
			}
		}

	}

}
