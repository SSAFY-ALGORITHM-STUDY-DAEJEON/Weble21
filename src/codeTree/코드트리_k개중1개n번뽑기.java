package codeTree;

import java.util.*;

public class 코드트리_k개중1개n번뽑기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();

		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = i + 1;
		}
		recursive(0, new int[n], arr);
	}

	private static void recursive(int k, int[] sel, int[] arr) {
		// basis
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		// inductive
		for (int i = 0; i < arr.length; i++) {
			if (k >= 2) {
				if (sel[k - 1] == arr[i] && sel[k - 2] == arr[i])
					continue;
			}
			sel[k] = arr[i];
			recursive(k + 1, sel, arr);
		}
	}
}
