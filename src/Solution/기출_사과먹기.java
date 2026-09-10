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

		State(int x, int y, int dir, int apple, int canTurn) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.apple = apple;
			this.canTurn = canTurn;
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
			int answer = bfs();
			System.out.println("#" + t + " " + answer);

		}
	}

	private static int bfs() {
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
		Deque<State> dq = new ArrayDeque<>();
		
		dist[0][0][0][1][1] = 0;
		
		dq.addFirst(new State(0,0,0,1,1));

		while(!dq.isEmpty()) {
			State cur = dq.pollFirst();
			
			int x = cur.x;
			int y = cur.y;
			int dir = cur.dir;
			int apple = cur.apple;
			int canTurn = cur.canTurn;
			
			int curCost = dist[x][y][dir][apple][canTurn];
			
			if(apple == m+1) {
				return curCost;
			}
			
			// 앞으로 이동
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx <0 || nx >= n || ny < 0 || ny >= n) {
				;
			} else {
				int nextApple = apple;
				if(arr[nx][ny] == apple) {
					nextApple++;
				}
				if(dist[nx][ny][dir][nextApple][1] > curCost) {
					dist[nx][ny][dir][nextApple][1] = curCost;
					
					dq.addFirst(new State(nx, ny, dir, nextApple, 1));
				}
			}
			// 오른쪽 회전, 비용 = 1
			if(canTurn == 1) {
				int nextDir = (dir+1)%4;
				if(dist[x][y][nextDir][apple][0] > curCost + 1) {
					dist[x][y][nextDir][apple][0] = curCost + 1;
					dq.addLast(new State(x, y, nextDir, apple, 0));
				}
				
			}			
			
		}
		return -1;
	}
}
