package Solution;

import java.io.*;
import java.util.*;

public class 숫자게임 {
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for(int t = 1; t <= tc; t++) {
			String str = bf.readLine();
			max = 0;
			splitNum(str, 0);
			System.out.println("#" + t + " " + max);
		}
	}

	private static void splitNum(String num, int count) {
		
		if(num.length() == 1) {
			max = Math.max(count, max);
			return;
		}
		int gapCnt = num.length() - 1;
		for(int mask = 1; mask < (1 << gapCnt); mask++) {
			int res = 1;
			int cur = 0;
			for(int i = 0; i < num.length(); i++) {
				int digit = num.charAt(i) - '0';
				cur = cur * 10 + digit;
				if(i < gapCnt && (mask & (1<<i)) != 0) {
					res *= cur;
					cur = 0;
				}
			}
			res *= cur;
			splitNum(String.valueOf(res), count + 1);
		}
	}
	
}
