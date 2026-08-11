package Solution;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 프로세서_연결하기 {
	static int n;
	static int[][] arr;
	static boolean[][] v;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());

			// 배열 생성
			v = new boolean[n][n];
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			System.out.println(Arrays.deepToString(arr));

		}
	}

	public static void dfs(int x, int y) {
		if(x == n-1 && y == n-1) {
			return;
		}
		if(arr[x][y] == 1) {
			v[x][y] = true;
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				while(true) {
					if((nx >= 0 && nx < n && ny < n && ny >= 0)) {
						if(arr[nx][ny] == 0) {
							arr[nx][ny] = 2;
						}
						nx = nx + 1;
						ny = ny + 1;
					} else {
						break;
					}
					
				}
				dfs(x + 1, y + 1);
			}
		}
		
		
	}
}
