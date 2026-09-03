package Solution;

import java.util.*;
import java.io.*;

public class 코드트리_강력한폭발 {
	static int n;
	static int[][] grid;
	static int[][] tmp_grid;
	static int Boom = -1;
	static int[] bomblist = { 1, 2, 3 };
	static ArrayList<int[]> list;
	static int max = 0;

	public static void bomb1(int x, int y) {
		int[] dx = new int[] { -2, -1, 1, 2, 0 };
		int[] dy = new int[] { 0, 0, 0, 0, 0 };
		for (int i = 0; i < 5; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n) {
				// 범위 밖
				continue;
			} else {
				// 범위 안
				grid[nx][ny] = Boom;
			}
		}
	}

	public static void bomb2(int x, int y) {
		int[] dx = new int[] { 1, -1, 0, 0, 0 };
		int[] dy = new int[] { 0, 0, 1, -1, 0 };
		for (int i = 0; i < 5; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				// 범위 밖
				continue;
			} else {
				// 범위 안
				grid[nx][ny] = Boom;
			}
		}
	}

	public static void bomb3(int x, int y) {
		int[] dx = new int[] { -1, -1, 1, 1, 0 };
		int[] dy = new int[] { -1, 1, -1, 1, 0 };
		for (int i = 0; i < 5; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				// 범위 밖
				continue;
			} else {
				// 범위 안
				grid[nx][ny] = Boom;
			}
		}
	}

	private static int bomb(int[] sel) {
		int result = 0;
		for (int i = 0; i < sel.length; i++) {
			switch (sel[i]) {
			case 1:
				bomb1(list.get(i)[0], list.get(i)[1]);
				result = cntGrid();
				
				break;
			case 2:
				bomb2(list.get(i)[0], list.get(i)[1]);
				result = cntGrid();
				
				break;
			case 3:
				bomb3(list.get(i)[0], list.get(i)[1]);
				result = cntGrid();
				
				break;
			default:
				break;
			}
			
			
		}
		return result;

	}

	private static int cntGrid() {
		int cnt = 0;
		for(int i = 0; i< n; i++) {
			for(int j = 0; j<n; j++) {
				if(grid[i][j] == Boom) {
					cnt++;
				}
			}
		}
		return cnt;
		
	}
	
	private static void recursive(int[] sel, int k) {
		// basis part
		if (k == sel.length) {			
			max = Math.max(max, bomb(sel));
			
			for(int i = 0; i< n; i++) {
				for(int j = 0; j<n; j++) {
					grid[i][j] = tmp_grid[i][j];
				}
			}
			
			
			return;
		}
		// inductive part
		for (int i = 0; i < bomblist.length; i++) {
			sel[k] = bomblist[i];
			recursive(sel, k + 1);

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		tmp_grid = new int[n][n];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
				tmp_grid[i][j] = grid[i][j];
				if (grid[i][j] == 1) {
					list.add(new int[] { i, j });
				}
			}
		}

		int[] arr = new int[list.size()];

		// Please write your code here.
		recursive(new int[list.size()], 0);
		
		System.out.println(max);
	}

}