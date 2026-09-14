package Solution;

import java.io.*;
import java.util.*;

public class 기출_전기자동차충전소 {
	static class House {
		int x;
		int y;
		int limit;

		House(int x, int y, int limit) {
			this.x = x;
			this.y = y;
			this.limit = limit;
		}
	}

	static int n;
	static House[] houses;
	static ArrayList<int[]> can;
	static int[][] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			houses = new House[n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int limit = Integer.parseInt(st.nextToken());

				houses[i] = new House(x, y, limit);
			}

			// 설치 가능한 곳 배열 만들기
			can = new ArrayList<>();
			for (int x = -15; x <= 15; x++) {
				for (int y = -15; y <= 15; y++) {
					boolean flag = true;
					for (int i = 0; i < n; i++) {
						if (houses[i].x == x && houses[i].y == y) {
							flag = false;
							break;
						} 
					}
					if(flag) {
						can.add(new int[] {x, y});
					}
				}
			}

			// 거리 계산
			int size = can.size();
			// dist[a][b] -> a번 후보에 설치했을때, b집까지의 거리
			dist = new int[size][n];
			for (int i = 0; i < size; i++) {
				int x = can.get(i)[0];
				int y = can.get(i)[1];
				for (int h = 0; h < n; h++) {
					dist[i][h] = Math.abs(x - houses[h].x) + Math.abs(y - houses[h].y);
				}
			}

			int res = checkOne();
			if(res == -1) {
				res = checkTwo();
			}
			
			System.out.println("#" + t + " " + res);
		}
	}

	private static int checkTwo() {
		int min = Integer.MAX_VALUE;
		int size = can.size();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				int sum = 0;
				boolean possible = true;
				for(int h = 0; h < n; h++) {
					int distance = Math.min(dist[i][h], dist[j][h]);
					if(distance > houses[h].limit) {
						possible = false;
						break;
					}
					sum += distance;
					
					if(sum >= min) {
						possible = false;
						break;
					}
				}
				if(possible) {
					min = Math.min(min, sum);
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		} else {
			return min;
		}
	}

	private static int checkOne() {
		int min = Integer.MAX_VALUE;
		int size = can.size();
		for (int i = 0; i < size; i++) {
			int sum = 0;
			boolean possible = true;

			for (int h = 0; h < n; h++) {
				int distance = dist[i][h];
				if (distance > houses[h].limit) {
					possible = false;
					break;
				}
				sum += distance;
			}
			if (possible) {
				min = Math.min(min, sum);
			}
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		} else {
			return min;
		}
	}
}
