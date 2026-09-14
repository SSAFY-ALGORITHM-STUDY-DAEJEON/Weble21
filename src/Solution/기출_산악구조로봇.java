package Solution;

import java.io.*;
import java.util.*;

public class 기출_산악구조로봇 {
	static int n;
	static int[][] arr;
	static int[][] dist;
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };

	static class Node {
		int x;
		int y;
		int fuel;

		Node(int x, int y, int fuel) {
			this.x = x;
			this.y = y;
			this.fuel = fuel;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = 0;

			dijkstra();
			
			System.out.println("#" + t + " " + dist[n-1][n-1]);
		}
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.fuel - b.fuel);
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int fuel = cur.fuel;
			if(dist[x][y] < cur.fuel) continue;
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				
				if(fuel > dist[nx][ny]) continue;
				
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
				
				int nextFuel = fuel + cost;
				if(nextFuel < dist[nx][ny]) {
					pq.offer(new Node(nx, ny, nextFuel));
					dist[nx][ny] = nextFuel;
				}
				
				
			}
			
		}

	}
}
