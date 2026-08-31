<<<<<<< HEAD
package Solution;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 프로세서_연결하기 {
	static int n;
	static int[][] arr;
	static ArrayList<int[]> core;
	static int maxConnected;
	static int minLen;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			core = new ArrayList<>();
			arr = new int[n][n];
			// arr 입력받기, core 리스트에 볼 곳만 저장하기
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (!(i == 0 || i == n - 1 || j == 0 || j == n - 1) && arr[i][j] == 1) {
						core.add(new int[] { i, j });
					}
				}
			}
			maxConnected = -1;
			minLen = Integer.MAX_VALUE;
			recursive(0, 0, 0);

			System.out.println("#" + t + " " + minLen);
		}
	}

	private static void recursive(int idx, int connected, int wireLen) {
		// basis part
		// 가지 치기 - 남은거 다 연결해도 최대로 연결 불가
		int rest = core.size() - idx;
		if (connected + rest < maxConnected) {
			return;
		}
		// 종료 시점
		if (idx == core.size()) {
			if (connected > maxConnected) {
				maxConnected = connected;
				minLen = wireLen;

			} else if (connected == maxConnected) {
				minLen = Math.min(wireLen, minLen);
			}
			return;
		}

		// inductive part
		int[] cur = core.get(idx);
		int x = cur[0];
		int y = cur[1];
		for (int d = 0; d < 4; d++) {
			
			if (canConnect(x, y, d)) {
				int newWireLen = setWire(x, y, d, 2);
				recursive(idx + 1, connected + 1, wireLen + newWireLen);
				// 선 깔고 왔으니 다시 초기화 (백트레킹)
				setWire(x, y, d, 0);
			}
		}
		recursive(idx + 1, connected, wireLen);

	}

	private static int setWire(int x, int y, int d, int value) {
		// value가 2면 선 깔기, 1이면 코어, 0이면 빈칸
		int nx = x + dx[d];
		int ny = y + dy[d];
		int len = 0;
		
		while (!(nx < 0 || nx >= n || ny < 0 || ny >= n)) {
			arr[nx][ny] = value;
			len++;
			
			nx = nx + dx[d];
			ny = ny + dy[d];
		}
		return len;
	}

	private static boolean canConnect(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		while (!(nx < 0 || nx >= n || ny < 0 || ny >= n)) {
			if (arr[nx][ny] != 0) {
				return false;
			}
			nx = nx + dx[d];
			ny = ny + dy[d];

		}

		return true;
	}
}
=======
package Solution;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 프로세서_연결하기 {
	static int n;
	static int[][] arr;
	static ArrayList<int[]> core;
	static int maxConnected;
	static int minLen;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			core = new ArrayList<>();
			arr = new int[n][n];
			// arr 입력받기, core 리스트에 볼 곳만 저장하기
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (!(i == 0 || i == n - 1 || j == 0 || j == n - 1) && arr[i][j] == 1) {
						core.add(new int[] { i, j });
					}
				}
			}
			maxConnected = -1;
			minLen = Integer.MAX_VALUE;
			recursive(0, 0, 0);

			System.out.println("#" + t + " " + minLen);
		}
	}

	private static void recursive(int idx, int connected, int wireLen) {
		// basis part
		// 가지 치기 - 남은거 다 연결해도 최대로 연결 불가
		int rest = core.size() - idx;
		if (connected + rest < maxConnected) {
			return;
		}
		// 종료 시점
		if (idx == core.size()) {
			if (connected > maxConnected) {
				maxConnected = connected;
				minLen = wireLen;

			} else if (connected == maxConnected) {
				minLen = Math.min(wireLen, minLen);
			}
			return;
		}

		// inductive part
		int[] cur = core.get(idx);
		int x = cur[0];
		int y = cur[1];
		for (int d = 0; d < 4; d++) {
			
			if (canConnect(x, y, d)) {
				int newWireLen = setWire(x, y, d, 2);
				recursive(idx + 1, connected + 1, wireLen + newWireLen);
				// 선 깔고 왔으니 다시 초기화 (백트레킹)
				setWire(x, y, d, 0);
			}
		}
		recursive(idx + 1, connected, wireLen);

	}

	private static int setWire(int x, int y, int d, int value) {
		// value가 2면 선 깔기, 1이면 코어, 0이면 빈칸
		int nx = x + dx[d];
		int ny = y + dy[d];
		int len = 0;
		
		while (!(nx < 0 || nx >= n || ny < 0 || ny >= n)) {
			arr[nx][ny] = value;
			len++;
			
			nx = nx + dx[d];
			ny = ny + dy[d];
		}
		return len;
	}

	private static boolean canConnect(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		while (!(nx < 0 || nx >= n || ny < 0 || ny >= n)) {
			if (arr[nx][ny] != 0) {
				return false;
			}
			nx = nx + dx[d];
			ny = ny + dy[d];

		}

		return true;
	}
}
>>>>>>> 6d3dbf7 (활주로 문제)
