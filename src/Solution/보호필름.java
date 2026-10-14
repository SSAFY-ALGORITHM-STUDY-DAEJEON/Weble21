package Solution;

import java.io.*;
import java.util.*;

public class 보호필름 {
	static int d, w, k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int result = k;
			
			int[][] arr = new int[d][w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (check(arr)) {
				result = 0;
			} else {
				for (int tk = 1; tk < k; tk++) {
					if (dfs(arr, 0, 0, tk)) {
						result = tk;
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	private static boolean dfs(int[][] arr, int start, int cnt, int k) {
		// basis part
		if (cnt == k) {
			boolean flag = check(arr);
			return flag;
		}

		// 남은 거 다 선택해도 k 못 채움
		if (d - start < k - cnt) {
			return false;
		}

		// inductive part
		for (int i = start; i < d; i++) {
			int[] tmp = arr[i];

			arr[i] = new int[w];
			boolean passed = dfs(arr, i + 1, cnt + 1, k);
			if(!passed) {
				Arrays.fill(arr[i], 1);
				passed = dfs(arr, i + 1, cnt + 1, k);
			}
			arr[i] = tmp;
			if(passed) {
				return true;
			}
			
		}
		return false;

	}

	private static boolean check(int[][] arr) {

		for (int j = 0; j < w; j++) {
			int cnt = 0;
			int cur = arr[0][j];
			boolean flag = false;
			for (int i = 0; i < d; i++) {
				if (arr[i][j] == cur) {
					cnt++;
				} else {
					cnt = 1;
					cur = arr[i][j];
				}

				if (cnt == k) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}

		}
		return true;

	}
}
