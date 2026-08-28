package Solution;

import java.io.*;
import java.util.StringTokenizer;

public class 문자들 {
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] arr;
	static int n, m, cnt;
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String nm = bf.readLine();
		StringTokenizer nmst = new StringTokenizer(nm);
		n = Integer.parseInt(nmst.nextToken());
		m = Integer.parseInt(nmst.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		cnt = 1;
		dfs(0, 0, new boolean[26], cnt);
		
		System.out.println(max);
	}

	private static void dfs(int x, int y, boolean[] v, int cnt) {
		if (v[arr[x][y] - 'A']) {
			max = Math.max(max, cnt);
			return;
		}

		v[arr[x][y] - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			if (!v[arr[nx][ny] - 'A']) {
				dfs(nx, ny, v, cnt + 1);
				v[arr[nx][ny] - 'A'] = false;
			}
			
		}
		max = Math.max(max, cnt);
	}
}
