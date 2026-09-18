package Solution;

import java.io.*;
import java.util.*;

public class 현주제곱근놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			long n = Long.parseLong(bf.readLine());
			int cnt = 0;
			while (n != 2) {
				long tmp = (long)Math.sqrt(n);
				if (tmp * tmp == n) {
					// System.out.println("yes");
					n = tmp;
					cnt++;
				} else {
					// System.out.println("no");
					long next = (tmp + 1) * (tmp+1);
					cnt += next-n;
					n = next;
				}
				
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
