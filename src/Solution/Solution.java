package Solution;

import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] v;
	static int n, k;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String nkr = bf.readLine();
			StringTokenizer nk = new StringTokenizer(nkr);
			n = Integer.parseInt(nk.nextToken());
			k = Integer.parseInt(nk.nextToken());

			arr = new int[n][n];
			int maxNum = -1;
			// v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					maxNum = Math.max(maxNum, arr[i][j]);
				}
			}
			result = 0;
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == maxNum) {
						dfs(i, j, new boolean[n][n], 1, false);
					}
				}
			}

			System.out.println("#" + tc + " " + result);

		}
	}

	static void dfs(int x, int y, boolean[][] v, int cnt, boolean flag) {
		// basis part
		// inductive part
		v[x][y] = true;
		result = Math.max(cnt, result);
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
				if (arr[nx][ny] < arr[x][y]) {
					v[nx][ny] = true;
					dfs(nx, ny, v, cnt + 1, flag);
					v[nx][ny] = false;
				} else {
					if (flag) {
						continue;
					} else {
						if (arr[nx][ny] - k < arr[x][y]) {
							
							arr[nx][ny] -= k;
							v[nx][ny] = true;
							dfs(nx, ny, v, cnt + 1, true);
							arr[nx][ny] += k;
							v[nx][ny] = false;
						} else {
							continue;
						}
					}
				}
			}

		}
	}
}
