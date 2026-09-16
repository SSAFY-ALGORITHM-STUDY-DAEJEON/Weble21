package Solution;

import java.io.*;
import java.util.*;

public class 팝핑팝핑지뢰찾기 {
	static int n;
	static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dy = { 1, 0, -1, 1, -1, 1, 0, -1 };
	static char[][] arr;
	static int[][] count;
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());
			
			arr = new char[n][n];
			count = new int[n][n];
			v = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == '*') {
						count[i][j] = -1;
						continue;
					}
					int cnt = 0;
					
					for (int d = 0; d < 8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
							continue;
						}

						if (arr[nx][ny] == '*') {
							cnt++;
						}
					}
					count[i][j] = cnt;
				}
			}

			// 1차 탐색
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (count[i][j] == 0 && !v[i][j]) {
						bfs(i, j);
						result++;
					}
				}
			}
			// 아직 클릭 못한 곳 있으면 추가
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!v[i][j] && arr[i][j] != '*') {
						result++;
					}
				}
			}

			System.out.println("#" + tc + " " + result);

		}
	}

	private static void bfs(int st_x, int st_y) {
		Deque<int[]> dq = new ArrayDeque<>();

		dq.offerLast(new int[] { st_x, st_y });
		v[st_x][st_y] = true;

		while (!dq.isEmpty()) {
			
			int[] cur = dq.pollFirst();
			int x = cur[0];
			int y = cur[1];
			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}

				if (v[nx][ny]) {
					continue;
				}

				if (arr[nx][ny] == '*') {
					continue;
				}

				v[nx][ny] = true;
				if (count[nx][ny] == 0) {
					dq.offerLast(new int[] { nx, ny });
				}
			}
		}
	}
}
