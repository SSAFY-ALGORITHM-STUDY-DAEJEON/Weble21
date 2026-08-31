<<<<<<< HEAD
package Solution;

import java.io.*;
import java.util.*;

public class 올해의조련사 {
	static char[] dq;
	static int start;
	static int end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			dq = new char[n];
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				dq[i] = str.charAt(0);
			}
			char[] res = new char[n];
			start = 0;
			end = n - 1;
			for (int i = 0; i < n; i++) {
				char result = checkArr();
				res[i] = result;
				// System.out.println(res);
			}

			// 출력
			System.out.print("#" + t + " ");
			for (int i = 0; i < n; i++) {
				System.out.print(res[i]);
			}
			System.out.println();

		}
	}
	
	// 투 포인터
	static char checkArr() {

		if (dq[start] != dq[end]) {
			int first = dq[start] - 'A';
			int last = dq[end] - 'A';
			int min = Math.min(first, last);
			char result;
			if (min == first) {
				result = dq[start];
				start++;
				return result;
			} else {
				result = dq[end];
				end--;
				return result;
			}
		} else {
			int tmp_start = start;
			int tmp_end = end;
			while (tmp_start < tmp_end) {
				tmp_start++;
				tmp_end--;
				if (dq[tmp_start] != dq[tmp_end]) {
					int first = dq[tmp_start] - 'A';
					int last = dq[tmp_end] - 'A';
					int min = Math.min(first, last);
					char result;
					if (min == first) {
						result = dq[start];
						start++;
						return result;
					} else {
						result = dq[end];
						end--;
						return result;
					}
				} else {
					continue;
				}
			}
			char result = dq[end];
			end--;
			return result;
		}
	}
}
=======
package Solution;

import java.io.*;
import java.util.*;

public class 올해의조련사 {
	static char[] dq;
	static int start;
	static int end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			dq = new char[n];
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				dq[i] = str.charAt(0);
			}
			char[] res = new char[n];
			start = 0;
			end = n - 1;
			for (int i = 0; i < n; i++) {
				char result = checkArr();
				res[i] = result;
				// System.out.println(res);
			}

			// 출력
			System.out.print("#" + t + " ");
			for (int i = 0; i < n; i++) {
				System.out.print(res[i]);
			}
			System.out.println();

		}
	}
	
	// 투 포인터
	static char checkArr() {

		if (dq[start] != dq[end]) {
			int first = dq[start] - 'A';
			int last = dq[end] - 'A';
			int min = Math.min(first, last);
			char result;
			if (min == first) {
				result = dq[start];
				start++;
				return result;
			} else {
				result = dq[end];
				end--;
				return result;
			}
		} else {
			int tmp_start = start;
			int tmp_end = end;
			while (tmp_start < tmp_end) {
				tmp_start++;
				tmp_end--;
				if (dq[tmp_start] != dq[tmp_end]) {
					int first = dq[tmp_start] - 'A';
					int last = dq[tmp_end] - 'A';
					int min = Math.min(first, last);
					char result;
					if (min == first) {
						result = dq[start];
						start++;
						return result;
					} else {
						result = dq[end];
						end--;
						return result;
					}
				} else {
					continue;
				}
			}
			char result = dq[end];
			end--;
			return result;
		}
	}
}
>>>>>>> 6d3dbf7 (활주로 문제)
