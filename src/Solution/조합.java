package Solution;

import java.io.*;
import java.util.*;

public class 조합 {
	static long P = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n, r;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			long a = factorial(n);
			long b = factorial(r);
			long c = factorial(n - r);

			long result = a % P * power(b, P - 2) % P * power(c, P - 2) % P;
			System.out.println("#" + t + " " + result);
		}
	}

	private static long power(long a, long k) {
		long result = 1;
		while (k > 0) {
			if (k % 2 == 1) {
				result = result * a % P;
			}
			k /= 2;
			a = a * a % P;
		}
		return result;
	}

	private static long factorial(int n) {
		long cnt = 1;
		for (int i = 1; i <= n; i++) {
			cnt = cnt * i % P;
		}
		return cnt;
	}
}
