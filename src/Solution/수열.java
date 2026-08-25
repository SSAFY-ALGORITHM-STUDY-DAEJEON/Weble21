package Solution;

import java.io.*;
import java.util.*;

public class 수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		String sstr = bf.readLine();
		StringTokenizer sst = new StringTokenizer(sstr);
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sst.nextToken());
			if(i != 0) {
				arr[i] += arr[i-1];
			}
		}
		int max = arr[k-1];
		for (int i = k; i < n; i++) {
			int sum = arr[i] - arr[i-k];
			max = Math.max(max, sum);
		}
		if(n == k) {
			max = arr[n-1];
		}
		System.out.println(max);
	}
}
