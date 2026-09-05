package Solution;

import java.util.*;
import java.io.*;

public class 코드트리_트로미노 {
	static int n;
	static int m;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		find_a(grid);
		find_b(grid);
		find_c(grid);
		find_d(grid);
		find_col(grid);
		find_row(grid);

		System.out.println(max);

	}

	private static void find_a(int[][] grid) {
		int[] dx = new int[] { -1, 0 };
		int[] dy = new int[] { 0, -1 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = i;
				int y = j;
				int sum = grid[x][y];
				boolean flag = true;
				for (int d = 0; d < 2; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						flag = false;
						break;
					}
					sum += grid[nx][ny];
				}
				if (flag) {
					max = Math.max(sum, max);
				}
			}
		}
	}

	private static void find_b(int[][] grid) {
		int[] dx = new int[] { -1, 0 };
		int[] dy = new int[] { 0, 1 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = i;
				int y = j;
				int sum = grid[x][y];
				boolean flag = true;
				for (int d = 0; d < 2; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						flag = false;
						break;
					}
					sum += grid[nx][ny];
				}
				if (flag) {
					max = Math.max(sum, max);
				}
			}
		}
	}

	private static void find_c(int[][] grid) {
		int[] dx = new int[] { 1, 0 };
		int[] dy = new int[] { 0, -1 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = i;
				int y = j;
				int sum = grid[x][y];
				boolean flag = true;
				for (int d = 0; d < 2; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						flag = false;
						break;
					}
					sum += grid[nx][ny];
				}
				if (flag) {
					max = Math.max(sum, max);
				}
			}
		}
	}

	private static void find_d(int[][] grid) {
		int[] dx = new int[] { 1, 0 };
		int[] dy = new int[] { 0, 1 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = i;
				int y = j;
				int sum = grid[x][y];
				boolean flag = true;
				for (int d = 0; d < 2; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						flag = false;
						break;
					}
					sum += grid[nx][ny];
				}
				if (flag) {
					max = Math.max(sum, max);
				}
			}
		}
	}

	private static void find_col(int[][] grid) {
		int[] dx = {1, 2};
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = i;
				int y = j;
				int sum = grid[x][y];
				boolean flag = true;
				for (int d = 0; d < 2; d++) {
					int nx = x + dx[d];
					if (nx < 0 || nx >= n) {
						flag = false;
						break;
					}
					sum += grid[nx][y];
				}
				if (flag) {
					max = Math.max(sum, max);
				}
			}
		}
	}

	private static void find_row(int[][] grid) {
		int[] dy = {1, 2};
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = i;
				int y = j;
				int sum = grid[x][y];
				boolean flag = true;
				for (int d = 0; d < 2; d++) {
					int ny = y + dy[d];
					if (ny < 0 || ny >= m) {
						flag = false;
						break;
					}
					sum += grid[x][ny];
				}
				if (flag) {
					max = Math.max(sum, max);
				}
			}
		}
	}

}
