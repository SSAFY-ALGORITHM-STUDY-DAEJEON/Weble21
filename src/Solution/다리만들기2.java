package Solution;

import java.io.*;
import java.util.*;

public class 다리만들기2 {
	static int n, m;
	static int map[][];
	private static final int[] dx = { -1, 1, 0, 0 };
	private static final int[] dy = { 0, 0, -1, 1 };

	static class Edge {
		int from;
		int to;
		int length;

		Edge(int from, int to, int length) {
			this.from = from;
			this.to = to;
			this.length = length;
		}
	}

	static ArrayList<Edge> edges = new ArrayList<>();
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int landNum = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, landNum);
					landNum++;
				}
			}
		}

		int landCnt = landNum - 2;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= 2) {
					findBridge(i, j);
				}
			}
		}

		parent = new int[landNum];
		for (int i = 2; i < landNum; i++) {
			parent[i] = i;
		}

		edges.sort((a, b) -> Integer.compare(a.length, b.length));

		int totalLength = 0;
		int selectedCnt = 0;

		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				totalLength += e.length;
				selectedCnt++;

				if (selectedCnt == landCnt - 1) {
					break;
				}
			}

		}
		// 모든 섬을 연결했는지 확인
		if (selectedCnt == landCnt - 1) {
			System.out.println(totalLength);
		} else {
			System.out.println(-1);
		}

	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return false;
		}

		parent[rootB] = rootA;
		return true;
	}

	private static void bfs(int x, int y, int landNum) {
		Queue<int[]> q = new ArrayDeque<>();

		map[x][y] = landNum;
		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}

				if (map[nx][ny] != 1) {
					continue;
				}

				map[nx][ny] = landNum;
				q.offer(new int[] { nx, ny });
			}
		}

	}

	private static void findBridge(int x, int y) {
		int from = map[x][y];

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			int length = 0;

			while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				// 땅 만나면
				if (map[nx][ny] != 0) {
					int to = map[nx][ny];

					if (to != from && length >= 2) {
						edges.add(new Edge(from, to, length));
					}

					break;
				}
				length++;

				nx += dx[d];
				ny += dy[d];

			}
		}
	}

}
