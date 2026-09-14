package Solution;

import java.util.*;
import java.io.*;

public class 기출_사과먹기 {
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n, m;
	static int cnt;
	static boolean[][] v;

	static class State {
		int x;
		int y;
		int dir;
		int apple;
		int canTurn;
		int cost;

		State(int x, int y, int dir, int apple, int canTurn, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.apple = apple;
			this.canTurn = canTurn;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			m = 0;
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] != 0) {
						m++;
					}
				}
			}
			int answer = dijkstra();
			System.out.println("#" + t + " " + answer);

		}
	}

	private static int dijkstra() {
		// [x][y][dir][apple][canTurn]
		int[][][][][] dist = new int[n][n][4][m + 2][2];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				for (int d = 0; d < 4; d++) {
					for (int a = 1; a <= m + 1; a++) {
						Arrays.fill(dist[x][y][d][a], Integer.MAX_VALUE);
					}
				}
			}
		}
		PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

		dist[0][0][0][1][1] = 0;

		pq.add(new State(0, 0, 0, 1, 1, 0));

		while (!pq.isEmpty()) {
			State cur = pq.poll();

			int x = cur.x;
			int y = cur.y;
			int dir = cur.dir;
			int apple = cur.apple;
			int canTurn = cur.canTurn;
			int curCost = cur.cost;

			if (curCost > dist[x][y][dir][apple][canTurn]) {
				continue;
			}
			if (apple == m + 1) {
				return curCost;
			}
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {

				int nextApple = apple;
				if (arr[nx][ny] == apple) {
					nextApple++;
				}
				if (dist[nx][ny][dir][nextApple][1] > curCost) {
					dist[nx][ny][dir][nextApple][1] = curCost;
					pq.add(new State(nx, ny, dir, nextApple, 1, curCost));
				}
				if (canTurn == 1) {
					int nextDir = (dir + 1) % 4;
					int nextCost = curCost + 1;
					if (dist[x][y][nextDir][apple][0] > nextCost) {
						dist[x][y][nextDir][apple][0] = nextCost;
						pq.add(new State(x, y, nextDir, apple, 0, nextCost));
					}
				}

			}
		}
		return -1;

	}
}
