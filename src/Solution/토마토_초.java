package Solution;

import java.util.*;
import java.io.*;

public class 토마토_초 {
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static int[][][] arr;
	static int m, n, h;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[m][n][h];
		ArrayList<int[]> tomato = new ArrayList<>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				String sstr = bf.readLine();
				StringTokenizer sst = new StringTokenizer(sstr);
				for (int k = 0; k < m; k++) {
					arr[k][j][i] = Integer.parseInt(sst.nextToken());
					if (arr[k][j][i] == 1) {
						tomato.add(new int[] { k, j, i });
					}
				}

			}
		}
		bfs(tomato);
		int result = 0;
		loop: for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (arr[k][j][i] == 0) {
						result = 0;
						break loop;
					} else {
						result = Math.max(result, arr[k][j][i]);
					}
				}

			}
		}
		System.out.println(result-1);

	}

	private static void bfs(ArrayList<int[]> tomato) {
		Deque<int[]> dq = new ArrayDeque<>();
		for (int[] is : tomato) {
			dq.offerLast(is);
		}

		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int curX = cur[0];
			int curY = cur[1];
			int curH = cur[2];
			int cnt = arr[curX][curY][curH] + 1;
			for (int d = 0; d < 6; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				int nh = curH + dh[d];
				if (nx < 0 || nx >= m || ny < 0 || ny >= n || nh < 0 || nh >= h) {
					continue;
				}
				if (arr[nx][ny][nh] != 0) {
					continue;
				}
				arr[nx][ny][nh] = cnt;
				dq.offerLast(new int[] {nx, ny, nh});
				
			}
		}
	}
}

