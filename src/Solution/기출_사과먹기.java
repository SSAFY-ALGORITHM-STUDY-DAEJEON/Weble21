package Solution;

import java.util.*;
import java.io.*;

public class 기출_사과먹기 {
	static int[][] arr;
	static int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int x, y, dir_state;
	static int n, m;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			Deque<int[]> apple = new ArrayDeque<>();
			m = 0;
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] != 0) {
						apple.addLast(new int[] { i, j });
						m++;
					}
				}
			}
			x = 0;
			y = 0;
			cnt = 0;
			dir_state = 0;
			for(int i = 0; i<m; i++) {
				bfs(apple);
			}
		
			System.out.println(cnt);

		}
	}
	
	private static void bfs(Deque<int[]> apple) {
		int[] end = apple.pollFirst();
		while(true) {
			
			if(x == end[0] && y == end[1]) {
				if(q.isEmpty()) break;
				end = q.pollFirst();
			}
			
			cnt++;
			if(dir_state % 2 == 1) {
				if(x != end[0]) {
					// 왼쪽이면
					if(chkXLeft((dir_state+3)%4, x, end[0])) {
						cnt += 4;
						dir_state += 3;
					}
					x += dir[dir_state%4][0];
					y += dir[dir_state%4][1];
				}
				if(x == end[0]) {
					dir_state++;
				}
			} else {
				if(y != end[1]) {
					// 왼쪽이면
					if(chkYLeft((dir_state+3)%4, y, end[1])) {
						cnt += 4;
						dir_state += 3;
					}
					x += dir[dir_state%4][0];
					y += dir[dir_state%4][1];
				}
				if(y == end[1]) {
					dir_state++;
				}
			}
		
			
		}
		
	}
}
