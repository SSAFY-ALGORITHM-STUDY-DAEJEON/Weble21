package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_K개벽없애기 {
	public static class Pos {
		int x;
		int y;
		int value;
		int kcnt;

		Pos(int x, int y, int value, int kcnt) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.kcnt = kcnt;
		}
	}

	static int n;
	static int k;
	static int[][] arr;
	static boolean[][][] v;
	static Pos start;
	static Pos end;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] result;

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
		start = new Pos(x, y, 0, 0);

		st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken()) - 1;
		y = Integer.parseInt(st.nextToken()) - 1;
		end = new Pos(x, y, 0, 0);

		bfs();
		if(result[end.x][end.y] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result[end.x][end.y]);
		}
		
	}

	private static void bfs() {
		result = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(result[i], Integer.MAX_VALUE);
		}

		v = new boolean[n][n][k+1];
		Queue<Pos> q = new ArrayDeque<>();
		q.add(start);
		result[start.x][start.y] = 0;
		v[start.x][start.y][0] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if (v[nx][ny][cur.kcnt]) {
					continue;
				}

				Pos tmp = new Pos(nx, ny, cur.value + 1, cur.kcnt);
				if (arr[nx][ny] == 0) {
					q.add(tmp);
					v[nx][ny][tmp.kcnt] = true;
					result[nx][ny] = Math.min(tmp.value, result[nx][ny]);
				} else {
					if (tmp.kcnt == k) {
						continue;
					} else {
						tmp.kcnt++;
						q.add(tmp);
						v[nx][ny][tmp.kcnt] = true;
						result[nx][ny] = Math.min(tmp.value, result[nx][ny]);
					}
				}

			}
		}

	}

}
