package Solution;

import java.io.*;
import java.util.*;

public class 사랑의카운슬러 {
	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static Pos[] ji_arrived;
	static Pos[] ji_stay;
	static int n;
	static long min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());
			Pos[] arr = new Pos[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i] = new Pos(x, y);
			}
			ji_arrived = new Pos[n / 2];
			ji_stay = new Pos[n / 2];
			min = Long.MAX_VALUE;
			recursive(arr, 0, 0);

			

			System.out.println("#" + tc + " " + min);
		}
	}

	
	private static void recursive(Pos[] arr, int st, int k) {
		// basis part
		if (k == n / 2) {
			int sum_x = 0;
			int sum_y = 0;
			for (int i = 0; i < ji_stay.length; i++) {
				// System.out.print(ji_stay[i].x + " " + ji_stay[i].y + " ");
				sum_x += ji_stay[i].x;
				sum_y += ji_stay[i].y;
			}
			for (int i = 0; i < arr.length; i++) {
				boolean contains = false;
				for (int j = 0; j < ji_stay.length; j++) {
					if(arr[i] == ji_stay[j]) {
						contains = true;
						break;
					}
				}
				
				if(!contains) {
					sum_x -= arr[i].x;
					sum_y -= arr[i].y;
				}
				
			}
			min = Math.min(min, calculate(sum_x, sum_y));

			return;
		}

		// inductive part
		for (int i = st; i < arr.length; i++) {
			ji_stay[k] = arr[i];
			recursive(arr, i + 1, k + 1);
		}

	}

	private static long calculate(int sum_x, int sum_y) {
		long result = (long)sum_x * sum_x + (long)sum_y * sum_y;

		return result;
	}

}
