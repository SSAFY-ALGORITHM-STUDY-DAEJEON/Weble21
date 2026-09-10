package Solution;

import java.io.*;
import java.util.*;

public class 기출_화분 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];

			for (int i = 0; i < 2; i++) {
				str = bf.readLine();
				st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][n];
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			for (int i = 1; i < n; i++) {
				// 현재 0번 비료 선택
				dp[0][i] = Math.max(sum(dp[0][i-1], arr[0][i], k), dp[1][i-1]+arr[0][i]);
				// 현재 1번 비료 선택
				dp[1][i] = Math.max(sum(dp[1][i-1], arr[1][i], k), dp[0][i-1]+arr[1][i]);
			}

			int res = Math.max(dp[0][n-1], dp[1][n-1]);
			System.out.println("#" + t + " " + res);

		}

	}

	static int change(int flag) {
		if (flag == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	static int sum(int a, int b, int k) {
		if (a + b - k <= 0) {
			return 1;
		}
		return a + b - k;
	}
}
