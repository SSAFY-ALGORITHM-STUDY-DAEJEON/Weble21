package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_상한귤 {
	static int n, k;
	static int[][] arr;
	static Queue<int[]> dead;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		dead = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					dead.add(new int[] { i, j });
				}
			}
		}
		bfs();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(result[i][j] == Integer.MAX_VALUE) {
					result[i][j] = -2;
				}
				if(arr[i][j] == 0) {
					result[i][j] = -1;
				}
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	static boolean[][] v;
	static Queue<int[]> q;
	private static void bfs() {
		result = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(result[i], Integer.MAX_VALUE);
		}
		q = new ArrayDeque<>();
		v = new boolean[n][n];
		while (!dead.isEmpty()) {
			int[] cur = dead.poll();
			q.add(new int[] { cur[0], cur[1] });
			result[cur[0]][cur[1]] = 0;
			v[cur[0]][cur[1]] = true;
		}
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if(v[nx][ny]) {
					continue;
				}
				if (arr[nx][ny] == 0) {
					result[nx][ny] = -1;
					continue;
				}
				q.add(new int[] {nx, ny});
				v[nx][ny] = true;
				result[nx][ny] = Math.min(result[x][y] + 1, result[nx][ny]);
				
			}
		}
	}
}
