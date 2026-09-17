package Solution;

import java.io.*;
import java.util.*;

public class 기출_알고스탁 {
	static int bank, earn, n, l;
	static int[][] stock;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			// bank : 예치금, earn : 불입금
			StringTokenizer st = new StringTokenizer(bf.readLine());
			bank = Integer.parseInt(st.nextToken());
			earn = Integer.parseInt(st.nextToken());

			// n : 종목수, l : 과거 데이터 기간
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			int base = bank + earn * l;
			stock = new int[n][l + 1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < l + 1; j++) {
					stock[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			market();
			int result = bank - base;
			System.out.println("#" + t + " " + result);

		}

	}

	private static void market() {
		for (int i = 0; i < l; i++) {
			int[] dp = new int[bank + 1];
			for (int money = 0; money <= bank; money++) {
				for (int j = 0; j < n; j++) {

					int price = stock[j][i];
					int profit = stock[j][i + 1] - stock[j][i];
					
					if(profit <= 0) {
						continue;
					}
					if(money >= price) {
						dp[money] = Math.max(dp[money], dp[money-price] + profit);
					}
				}

			}
			bank += dp[bank];
			bank += earn;
		}

	}
}
