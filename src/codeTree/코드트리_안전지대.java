package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_안전지대 {
	static int n, m;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
			}
		}
		int resultSafe = 0;
		int resultK = 1;
		for (int k = 1; k < max; k++) {
			visited = new boolean[n][m];
			int safe = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && arr[i][j] > k) {
						dfs(k, new int[] { i, j });
						safe++;
					}
				}
			}
			if(safe > resultSafe) {
				resultSafe = safe;
				resultK = k;
			}
		}
		System.out.println(resultK + " " + resultSafe);

	}

	private static void dfs(int k, int[] cur) {
		Stack<int[]> s = new Stack<>();
		s.add(cur);
		visited[cur[0]][cur[1]] = true;

		while (!s.isEmpty()) {
			cur = s.pop();
			int x = cur[0];
			int y = cur[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				if(visited[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] <= k) {
					visited[nx][ny] = true;
					continue;
				}
				s.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}

	}
}
