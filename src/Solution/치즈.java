<<<<<<< HEAD
package Solution;

import java.io.*;
import java.util.*;

public class 치즈 {
	static int n, m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] arr;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		ArrayList<Integer> remains = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String tmp = bf.readLine();
			StringTokenizer tmpst = new StringTokenizer(tmp);
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(tmpst.nextToken());
				if(i == 0 || i == n-1 || j == 0 || j == m-1) {
					arr[i][j] = 3;
				}
				if(arr[i][j] == 1) cnt++;
			}
		}
		int time = 0;
		remains.add(cnt);
		loop: while (true) {
			int remain = 0;
			v = new boolean[n][m];
			time++;
			dfsForAir();
			
			v = new boolean[n][m];
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					
					if (arr[i][j] == 1 && !v[i][j]) { 
						remain += dfs(i, j);			
					}
				}
			}
			
			//System.out.println("remain: " + remain);
			remains.add(remain);
			if (remain == 0) break loop;
			
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					if (arr[i][j] == 2) {
						arr[i][j] = 3;						
					}
				}
			}
			

		}
		
		remains.remove(remains.size() - 1);
		System.out.println(time);
		System.out.println(remains.get(remains.size() - 1));
		

	}
	
	static void dfsForAir() {
		
		Deque<int[]> s = new ArrayDeque<>();
		s.offerLast(new int[]{0, 0});
        v[0][0] = true;
		
	
		while (!s.isEmpty()) {
			int[] cur = s.pollLast();
			int cur_x = cur[0];
			int cur_y = cur[1];
			for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (v[nx][ny])
					continue;
				if(arr[nx][ny] == 0 || arr[nx][ny] == 3) {
					arr[nx][ny] = 3;
					s.offerLast(new int[] {nx, ny});
					v[nx][ny] = true;
				}
				
			}
		}
		
	}
	

	static int dfs(int x, int y) {
		int rest_cnt = 0;
		Deque<int[]> s = new ArrayDeque<>();
		v[x][y] = true;
		s.offerLast(new int[] { x, y });
		if (check(x, y)) {
			arr[x][y] = 2;
		} else {
			rest_cnt++;
		}
		

		while (!s.isEmpty()) {
			int[] cur = s.pollLast();
			int cur_x = cur[0];
			int cur_y = cur[1];
			for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if (nx < 1 || nx >= n - 1 || ny < 1 || ny >= m - 1)
					continue;
				if (v[nx][ny])
					continue;

				if (arr[nx][ny] == 1) {
					v[nx][ny] = true;
					s.offerLast(new int[] { nx, ny });
					if (check(nx, ny)) {
						arr[nx][ny] = 2;
					} else {
						rest_cnt++;
					}
				}
			}
		}
		return rest_cnt;
	}

	static boolean check(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (arr[nx][ny] == 3) {
				return true;
			}
		}
		return false;
	}
	
	
}
=======
package Solution;

import java.io.*;
import java.util.*;

public class 치즈 {
	static int n, m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] arr;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		ArrayList<Integer> remains = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String tmp = bf.readLine();
			StringTokenizer tmpst = new StringTokenizer(tmp);
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(tmpst.nextToken());
				if(i == 0 || i == n-1 || j == 0 || j == m-1) {
					arr[i][j] = 3;
				}
				if(arr[i][j] == 1) cnt++;
			}
		}
		int time = 0;
		remains.add(cnt);
		loop: while (true) {
			int remain = 0;
			v = new boolean[n][m];
			time++;
			dfsForAir();
			
			v = new boolean[n][m];
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					
					if (arr[i][j] == 1 && !v[i][j]) { 
						remain += dfs(i, j);			
					}
				}
			}
			
			//System.out.println("remain: " + remain);
			remains.add(remain);
			if (remain == 0) break loop;
			
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					if (arr[i][j] == 2) {
						arr[i][j] = 3;						
					}
				}
			}
			

		}
		
		remains.remove(remains.size() - 1);
		System.out.println(time);
		System.out.println(remains.get(remains.size() - 1));
		

	}
	
	static void dfsForAir() {
		
		Deque<int[]> s = new ArrayDeque<>();
		s.offerLast(new int[]{0, 0});
        v[0][0] = true;
		
	
		while (!s.isEmpty()) {
			int[] cur = s.pollLast();
			int cur_x = cur[0];
			int cur_y = cur[1];
			for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (v[nx][ny])
					continue;
				if(arr[nx][ny] == 0 || arr[nx][ny] == 3) {
					arr[nx][ny] = 3;
					s.offerLast(new int[] {nx, ny});
					v[nx][ny] = true;
				}
				
			}
		}
		
	}
	

	static int dfs(int x, int y) {
		int rest_cnt = 0;
		Deque<int[]> s = new ArrayDeque<>();
		v[x][y] = true;
		s.offerLast(new int[] { x, y });
		if (check(x, y)) {
			arr[x][y] = 2;
		} else {
			rest_cnt++;
		}
		

		while (!s.isEmpty()) {
			int[] cur = s.pollLast();
			int cur_x = cur[0];
			int cur_y = cur[1];
			for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if (nx < 1 || nx >= n - 1 || ny < 1 || ny >= m - 1)
					continue;
				if (v[nx][ny])
					continue;

				if (arr[nx][ny] == 1) {
					v[nx][ny] = true;
					s.offerLast(new int[] { nx, ny });
					if (check(nx, ny)) {
						arr[nx][ny] = 2;
					} else {
						rest_cnt++;
					}
				}
			}
		}
		return rest_cnt;
	}

	static boolean check(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (arr[nx][ny] == 3) {
				return true;
			}
		}
		return false;
	}
	
	
}
>>>>>>> 6d3dbf7 (활주로 문제)
