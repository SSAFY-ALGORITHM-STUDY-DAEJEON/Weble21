package Solution;

import java.io.*;
import java.util.*;

public class 등산로_조성 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] v;
	static int n, k;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String nkr = bf.readLine();
			StringTokenizer nk = new StringTokenizer(nkr);
			n = Integer.parseInt(nk.nextToken());
			k = Integer.parseInt(nk.nextToken());

			arr = new int[n][n];
			int maxNum = -1;
			//등산로 높이 입력 받고, 제일 높은 곳의 값 저장
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					maxNum = Math.max(maxNum, arr[i][j]);
				}
			}
			result = 0;
			//제일 높은 곳들만 dfs 탐색 시작
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == maxNum) {
						dfs(i, j, new boolean[n][n], 1, false);
					}
				}
			}

			System.out.println("#" + tc + " " + result);

		}
	}

	static void dfs(int x, int y, boolean[][] v, int cnt, boolean flag) {
		// basis part
		// inductive part
		v[x][y] = true;
		result = Math.max(cnt, result);
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
				//더 작을경우
				if (arr[nx][ny] < arr[x][y]) {
					v[nx][ny] = true;
					//백트래킹
					dfs(nx, ny, v, cnt + 1, flag);
					v[nx][ny] = false;
				} else {
					//더 이상 못 가면, 다른 방향으로 탐색
					if (flag) {
						continue;
					} else {
						if (arr[nx][ny] - k < arr[x][y]) {
							//공사하는 겨우
							int tmp = arr[nx][ny];
							//이전 지형의 높이와 제일 값이 적게 공사하기
							arr[nx][ny] = arr[x][y] - 1;
							v[nx][ny] = true;
							//백트래킹
							dfs(nx, ny, v, cnt + 1, true);
							//다른 방향에서 이 칸을 다시 방문할 수 있기 때문에 다시 원상복귀
							arr[nx][ny] = tmp;
							v[nx][ny] = false;
						} else {
							//더 이상 못 가면, 다른 방향으로 탐색
							continue;	
						}
					}
				}
			}

		}
	}
}

