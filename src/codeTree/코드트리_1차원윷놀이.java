package codeTree;

import java.util.*;

public class 코드트리_1차원윷놀이 {
	static int[] arr;
	static int n, m, k;
	static int max = 0;
	static int[] tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		tmp = new int[k];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] horse = new int[k];
		for (int i = 0; i < k; i++) {
			horse[i] = i;
		}
		recursive(0, new int[n], horse);
		System.out.println(max);
	}

	public static void recursive(int k, int[] sel, int[] horse) {
		// basis
		if (k == sel.length) {
			int tmp = calculate(sel);
			if(max > tmp) {
				return;
			}
			max = Math.max(max, tmp);
			return;
		}
		

		// inductive
		for (int i = 0; i < horse.length; i++) {
			sel[k] = horse[i];
			recursive(k + 1, sel, horse);
		}

	}

	private static int calculate(int[] sel) {
		
		Arrays.fill(tmp, 1);
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (tmp[sel[i]] >= 0) {
				tmp[sel[i]] += arr[i];
				if (tmp[sel[i]] >= m) {
					result++;
					tmp[sel[i]] = -1;
				}
			} else {
				continue;
			}
		}
		return result;

	}
}