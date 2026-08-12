package Solution;

import java.io.*;
import java.util.*;

public class 치즈도둑 {
	static int[][] arr;
	static int n;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 1;
			for (int d = 1; d < 100; d++) {
				v = new boolean[n][n];
				int cnt = 0;
				
				for(int i = 0; i<n; i++) {
					for(int j = 0; j<n; j++) {
						if(!v[i][j] && arr[i][j] > d) {
							dfs(d, i, j, v);
							cnt++;
						}
						
					}
				}
				result = Math.max(cnt, result);
			}
			System.out.println("#" + t + " " + result);

		}
	}

	private static void dfs(int d, int x, int y, boolean[][] v) {
		
		v[x][y] = true;
		for(int k = 0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx >= 0 && nx < n && ny < n && ny >= 0 && !v[nx][ny]) {
				if(arr[nx][ny] > d) {
					dfs(d, nx, ny, v);
				}
			}
		}
		
	}

}
