package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 오셀로 {
	static int[][] arr;
	static int n;
	static int m;

	static int[] dx = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = new int[] { 1, 0, 1, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// 버퍼 선언
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 라인 단위로 입력받기
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			arr[n / 2][n / 2] = 2; // white
			arr[n / 2 - 1][n / 2 - 1] = 2;
			arr[n / 2][n / 2 - 1] = 1; // black
			arr[n / 2 - 1][n / 2] = 1;
			for (int i = 0; i < m; i++) {
				String str1 = bf.readLine();
				StringTokenizer sst = new StringTokenizer(str1);
				int x = Integer.parseInt(sst.nextToken()) - 1;
				int y = Integer.parseInt(sst.nextToken()) - 1;
				int color = Integer.parseInt(sst.nextToken());
				arr[x][y] = color;
				search(x, y, color);
//                for(int i1 = 0; i1<n; i1++) {
//                	for(int j1 =0; j1<n; j1++) {
//                		System.out.print(arr[i1][j1] + " ");
//                	}
//                	System.out.println();
//                }
//                System.out.println();
			}
			int one = 0;
			int two = 0;
			for (int k = 0; k < n; k++) {
				for (int j = 0; j < n; j++) {
					if (arr[k][j] == 1) {
						one++;
					} else if (arr[k][j] == 2) {
						two++;
					}
				}

			}
			System.out.println("#" + tc + " " + one + " " + two);
		}
		

	}

	static void search(int x, int y, int color) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			while (!(nx < 0 || nx >= n || ny < 0 || ny >= n) && arr[nx][ny] != 0) {
				if (arr[nx][ny] == color) {
					int minX = Math.min(nx, x);
					int maxX = Math.max(nx, x);
					int minY = Math.min(ny, y);
					int maxY = Math.max(ny, y);

					int tmpX = x;
					int tmpY = y;
					if (nx == x) {
						for (int k = minY; k < maxY; k++) {
							if (arr[tmpX + dx[i]][tmpY + dy[i]] == 0) {
								continue;
							}
							arr[tmpX + dx[i]][tmpY + dy[i]] = color;
							tmpX += dx[i];
							tmpY += dy[i];
						}
					} else {
						for (int k = minX; k < maxX; k++) {
							if (arr[tmpX + dx[i]][tmpY + dy[i]] == 0) {
								continue;
							}
							arr[tmpX + dx[i]][tmpY + dy[i]] = color;
							tmpX += dx[i];
							tmpY += dy[i];
						}

					}

					break;
				} else {
					nx = nx + dx[i];
					ny = ny + dy[i];
				}
			}

		}

	}
}
