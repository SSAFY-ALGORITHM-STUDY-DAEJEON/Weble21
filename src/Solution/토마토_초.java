package Solution;

import java.util.*;
import java.io.*;

public class 토마토_초 {
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
//	public static class Node {
//		int x;
//		int y;
//		int h;
//		Node(int x, int y, int h) {
//			this.x = x;
//			this.y = y;
//			this.h = h;
//		}
//	}
	static boolean[][][] visited;
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
		visited = new boolean[m][n][h];
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
		for (int i = 0; i < tomato.size(); i++) {
			bfs(tomato.get(i));
		}
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

	private static void bfs(int[] tomato) {
		Deque<int[]> dq = new ArrayDeque<>();
		int curX = tomato[0];
		int curY = tomato[1];
		int curH = tomato[2];
		//visited[curX][curY][curH] = true;
		dq.offerLast(new int[] { curX, curY, curH });

		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			curX = cur[0];
			curY = cur[1];
			curH = cur[2];
			int tmp = arr[curX][curY][curH];
			int cnt = tmp + 1;
			for (int d = 0; d < 6; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				int nh = curH + dh[d];
				if (nx < 0 || nx >= m || ny < 0 || ny >= n || nh < 0 || nh >= h) {
					continue;
				}
				if (arr[nx][ny][nh] == -1) {
					continue;
				}
				if(arr[nx][ny][nh] == 0) {
					arr[nx][ny][nh] = cnt;
					dq.offerLast(new int[] {nx, ny, nh});
				}
				
				if (cnt >= arr[nx][ny][nh]) {
					continue;
				} else {
					arr[nx][ny][nh] = cnt;
					dq.offerLast(new int[] {nx, ny, nh});
				}
				
			}
		}
	}
}
