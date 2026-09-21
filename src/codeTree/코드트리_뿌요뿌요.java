package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_뿌요뿌요 {
	static int n;
	static int[][] arr;
	static boolean[][] v;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int block = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
					int tmp = dfs(new int[] { i, j });
					max = Math.max(tmp, max);
					if(tmp >= 4) {
						block++;
					}
				}
			}
		}
		System.out.println(block + " " + max);

	}

	private static int dfs(int[] cur) {
		Stack<int[]> s = new Stack<>();
		s.add(cur);
		v[cur[0]][cur[1]] = true;
		int cnt = 1;
		
		while (!s.isEmpty()) {
			cur = s.pop();
			int x = cur[0];
			int y = cur[1];
			int tmp = arr[x][y];
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if(v[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] == tmp) {
					s.add(new int[] {nx, ny});
					v[nx][ny] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
