package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_K번최댓값으로이동하기 {
	static int n, k;
	static int[][] arr;
	static boolean[][] v;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < k; i++) {
			v = new boolean[n][n];
			int max = bfs(new int[] { x, y });
			if(max == 0) {
				break;
			}
			loop : for (int t = 0; t < n; t++) {
				for (int j = 0; j < n; j++) {
					if(arr[t][j] == max) {
						x = t;
						y = j;
						break loop;
					}
				}
			}
		}
		x++;
		y++;
		System.out.println(x + " " + y);

	}

	private static int bfs(int[] cur) {
		int max = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(cur);
		v[cur[0]][cur[1]] = true;
		int std = arr[cur[0]][cur[1]];
		while (!q.isEmpty()) {
			cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if (v[nx][ny]) {
					continue;
				}
				if (arr[nx][ny] >= std) {
					continue;
				}
				max = Math.max(max, arr[nx][ny]);
				q.add(new int[] { nx, ny });
				v[nx][ny] = true;
			}
		}
		return max;

	}
}
