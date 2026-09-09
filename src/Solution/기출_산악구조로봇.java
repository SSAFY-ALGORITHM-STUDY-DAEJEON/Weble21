package Solution;

import java.io.*;
import java.util.*;

public class 기출_산악구조로봇 {
	static int n;
	static int[][] arr;
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int fuel;

		Node(int x, int y, int fuel) {
			this.x = x;
			this.y = y;
			this.fuel = fuel;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.fuel - o.fuel;
		}
	}

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
			int result = dijkstra();

			System.out.println("#" + t + " " + result);
		}
	}

	private static int dijkstra() {
		int[][] dist = new int[n][n];
		for(int i = 0; i<n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = 0;
		pq.offer(new Node(0,0,0));
		
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int fuel = cur.fuel;
			
			if(fuel > dist[x][y]) {
				continue;
			}
			if(x == n - 1 && y == n - 1) {
				return fuel;
			}
			
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				int cost;
				// 높이가 같음
				if(arr[x][y] == arr[nx][ny]) {
					cost = 1;
				} 
				// 오르막
				else if(arr[x][y] < arr[nx][ny]) {
					int tmp = arr[nx][ny] - arr[x][y];
					cost = tmp * 2;
				}
				else {
					cost = 0;
				}
				int nextFuel = fuel+cost;
				if(nextFuel < dist[nx][ny]) {
					dist[nx][ny] = nextFuel;
					pq.offer(new Node(nx, ny, nextFuel));
				}
			}
			
		}
		return dist[n-1][n-1];
	}
}
