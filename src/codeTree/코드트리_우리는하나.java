package codeTree;

import java.util.*;

public class 코드트리_우리는하나 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int max = 0;
	static int n, k, U, D;
	static int[][] cities;
	static int[][] grid;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		cities = new int[k][2];
		combination(0, 0, 0);
		
		System.out.println(max);
		
	}

	private static void combination(int x, int y, int depth) {
		if (depth == k) {
			boolean[][] v = new boolean[n][n];
			int sum = 0;
			
			for(int i = 0; i < cities.length; i++) {
				int nx = cities[i][0];
				int ny = cities[i][1];
				
				if(v[nx][ny]) continue;
				
				int res = bfs(nx, ny, v);
				sum += res;
				max = Math.max(sum, max);
			}
			return;
		}

		for (int i = x; i < n; i++) {
			for (int j = y; j < n; j++) {
				cities[depth][0] = i;
				cities[depth][1] = j;

				combination(i, j+1, depth + 1);
			}

		}

	}

	private static int bfs(int x, int y, boolean[][] v) {
		int cnt = 1;
		Queue<int[]> q = new ArrayDeque<>();

		int[] cur = new int[] { x, y };
		q.add(cur);
		v[x][y] = true;

		while (!q.isEmpty()) {
			cur = q.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = cur_x + dx[d];
				int ny = cur_y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (v[nx][ny])
					continue;

				int diff = Math.abs(grid[nx][ny] - grid[cur_x][cur_y]);
				if (diff >= U && diff <= D) {
					q.add(new int[] { nx, ny });
					v[nx][ny] = true;
					cnt++;
				}
			}
		}

		return cnt;
	}
}
