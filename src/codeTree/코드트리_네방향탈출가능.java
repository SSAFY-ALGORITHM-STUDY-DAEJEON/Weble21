package codeTree;

import java.util.*;

public class 코드트리_네방향탈출가능 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();
		boolean[][] v = new boolean[n][m];
		// 0이면 뱀이 있음. 1이면 없음
		// Please write your code here.
		int res = bfs(grid, v);
		System.out.println(res);

	}

	private static int bfs(int[][] grid, boolean[][] v) {
		int cur_x = 0;
		int cur_y = 0;
		Deque<int[]> dq = new ArrayDeque<>();

		dq.offerLast(new int[] { cur_x, cur_y });
		v[cur_x][cur_y] = true;
		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			cur_x = cur[0];
			cur_y = cur[1];
			if(cur_x == n-1 && cur_y == m-1) {
				return 1;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = cur_x + dx[d];
				int ny = cur_y + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (v[nx][ny]) continue;
				if(grid[nx][ny] == 1) {
					dq.offerLast(new int[] {nx, ny});
					v[nx][ny] = true;
				}
			}
		}
		return 0;

	}
}