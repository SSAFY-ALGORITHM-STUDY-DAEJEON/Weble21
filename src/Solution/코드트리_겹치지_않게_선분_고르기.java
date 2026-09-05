package Solution;

import java.io.*;
import java.util.*;

public class 코드트리_겹치지_않게_선분_고르기 {
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		boolean[] chk = new boolean[1001];
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		recursive(chk, arr, 0, 0);
		System.out.println(max);

	}

	private static void recursive(boolean[] chk, int[][] arr, int k, int cnt) {
		// basis part

		if (k == arr.length) {
			max = Math.max(max, cnt);
			return;
		}

		// inductive part

		// 현재 선분 선택 안함
		recursive(chk, arr, k + 1, cnt);
		for (int i = arr[k][0]; i <= arr[k][1]; i++) {
			if (chk[i] == true) {
				return;
			}
		}

		// 현재 선분 선택할때
		for (int i = arr[k][0]; i <= arr[k][1]; i++) {
			chk[i] = true;
		}
		recursive(chk, arr, k + 1, cnt + 1);
		for (int i = arr[k][0]; i <= arr[k][1]; i++) {
			chk[i] = false;
		}
	}
}
