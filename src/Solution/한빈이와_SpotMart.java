package Solution;

import java.io.*;
import java.util.*;

public class 한빈이와_SpotMart {
	static int n, m;
	static int max = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			max = -1;
			String nm = bf.readLine();
			StringTokenizer nmst = new StringTokenizer(nm);
			n = Integer.parseInt(nmst.nextToken());
			m = Integer.parseInt(nmst.nextToken());

			int[] arr = new int[n];
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());

			}
			System.out.println(Arrays.toString(arr));
			
			recursive(arr, new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}, 0, new boolean[n]);
			if(arr.length < 2) {
				max = -1;
			}
			if(max == 0) {
				max = -1;
			}
			System.out.println("#" + t + " " + max);
		}

	}

	static void recursive(int[] arr, int[] sel, int k, boolean[] v) {

		// basis part
		if (k == sel.length) {
			int sum = sel[0] + sel[1];
			if (sum <= m) {
				System.out.println(Arrays.toString(sel));
				max = Math.max(max, sum);
			}
			return;
		}

		// inductive part
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > m) {
				continue;
			}

			if (!v[i]) {
				sel[k] = arr[i];
			}
			v[i] = true;
			recursive(arr, sel, k + 1, v);
			v[i] = false;
		}
	}
}
