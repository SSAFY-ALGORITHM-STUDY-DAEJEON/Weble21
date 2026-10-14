package Solution;

import java.io.*;
import java.util.*;

public class knapsack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n, k;
			int[] volume;
			int[] cost;
			int[][] dp;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			dp = new int[n + 1][k + 1];
			volume = new int[n + 1];
			cost = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				dp[i][0] = 0;
			}

			for (int i = 0; i < k + 1; i++) {
				dp[0][i] = 0;
			}

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(bf.readLine());
				volume[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				for (int w = 1; w <= k; w++) {
					if (volume[i] <= w) {
						dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - volume[i]] + cost[i]);
					} else {
						dp[i][w] = dp[i - 1][w];
					}
				}
			}

			System.out.println("#" + t + " " + dp[n][k]);
		}
	}
}
