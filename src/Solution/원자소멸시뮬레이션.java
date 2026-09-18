package Solution;

import java.io.*;
import java.util.*;

public class 원자소멸시뮬레이션 {

	public static class Atom {
		double x;
		double y;
		int dist;
		int e;
		boolean exist;

		Atom(int x, int y, int dist, int e) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.e = e;

			this.exist = true;
		}
	}

	static Atom[] arr;
	static int cnt;
	static int eSum;
	static int[][] map = new int[4001][4001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			
			int n = Integer.parseInt(bf.readLine());
			arr = new Atom[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				arr[i] = new Atom(x, y, dist, e);
			}
			
			eSum = 0;
			cnt = 0;
			
			while (cnt != n) {				
				move();
				conflictCheck();
			}
			
			System.out.println("#" + t + " " + eSum);
		}
	}

	private static void conflictCheck() {
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].exist) {
				continue;
			}

			if (arr[i].x > 1000 || arr[i].x < -1000 || arr[i].y > 1000 || arr[i].y < -1000) {
				arr[i].exist = false;
				cnt++;
				continue;
			}
			
			int x = (int) (arr[i].x * 2) + 2000;
			int y = (int) (arr[i].y * 2) + 2000;
			
			if(map[x][y] > 1) {
				arr[i].exist = false;
				cnt++;
				eSum += arr[i].e;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			if (arr[i].x > 1000 || arr[i].x < -1000 || arr[i].y > 1000 || arr[i].y < -1000) {
				continue;
			}
			
			int x = (int) (arr[i].x * 2) + 2000;
			int y = (int) (arr[i].y * 2) + 2000;
			map[x][y] = 0;
		}
	}

	private static void move() {
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].exist) {
				continue;
			}
			switch (arr[i].dist) {
			case 0: {
				// up
				arr[i].y += 0.5;
				break;
			}
			case 1: {
				// down
				arr[i].y -= 0.5;
				break;
			}
			case 2: {
				// left
				arr[i].x -= 0.5;
				break;
			}
			case 3: {
				// right
				arr[i].x += 0.5;
				break;
			}

			default:
				break;
			}
			
			if (arr[i].x > 1000 || arr[i].x < -1000 || arr[i].y > 1000 || arr[i].y < -1000) {
				continue;
			}
			int x = (int) (arr[i].x * 2) + 2000;
			int y = (int) (arr[i].y * 2) + 2000;
			
			map[x][y]++;

		}

	}
}
