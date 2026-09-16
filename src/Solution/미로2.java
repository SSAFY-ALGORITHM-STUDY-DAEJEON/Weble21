package Solution;

import java.util.*;
import java.io.*;

public class 미로2 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n = 100;
	static int[] start = new int[2];
	static int[] end = new int[2];
	static int[][] arr;
	static boolean[][] v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(bf.readLine());			
			arr = new int[n][n];
			v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
					if (arr[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
					if (arr[i][j] == 3) {
						end[0] = i;
						end[1] = j;
					}
				}
			}
			if(dfs()) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}

	private static boolean dfs() {
		ArrayDeque<int[]> s = new ArrayDeque<>();
		
		s.addLast(start);
		v[start[0]][start[1]] = true;
		
		while(!s.isEmpty()) {
			int[] cur = s.pollLast();
			int x = cur[0];
			int y = cur[1];
			if(x == end[0] && y == end[1]) {
				return true;
			}
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if(v[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] == 1) {
					continue;
				}
				v[nx][ny] = true;
				s.addLast(new int[] {nx, ny});				
			}
		}
		return false;
		
	}

}
