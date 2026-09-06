package codeTree;

import java.util.*;

public class 코드트리_금채굴 {
	static int[][] grid;
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 영역 크기 = n
		n = sc.nextInt();
		// 금 가격 = m
		m = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		// Please write your code here.
		int max = 0;
		for (int k = 0; k <= n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int res = findGold(i, j, k);
					max = Math.max(max,  res);
				}
			}
		}
		System.out.println(max);

	}

	private static int findGold(int x, int y, int k) {
		int money = (k * k) + ((k + 1) * (k + 1));
		int cnt = 0;
		int tmpk = k;
		for (int j = y; j >= y - k; j--) {
			for (int i = x - tmpk; i <= x + tmpk; i++) {
				if (i < 0 || i >= n || j < 0 || j >= n) {
					continue;
				} else {
					if (grid[i][j] == 1) { 
						cnt++;
					}
				}
			}
			tmpk--;
		}
		tmpk = k - 1;
		for (int j = y + 1; j <= y + k; j++) {
			for (int i = x - tmpk; i <= x + tmpk; i++) {
				if (i < 0 || i >= n || j < 0 || j >= n) {
					continue;
				} else {
					if (grid[i][j] == 1) {
						cnt++;
					}
				}
			}
			tmpk--;
		}
		if(cnt * m >= money) {
			return cnt;
		} else {
			return 0;
		}		

	}
}
