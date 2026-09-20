package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_알파벳사칙연산 {
	static ArrayList<Character> alpha;
	static String str;
	static int[] value = new int[6];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str = bf.readLine();
		int l = str.length() + 1 / 2;
		alpha = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0 || i == 0) {
				if (alpha.contains(str.charAt(i))) {
					continue;
				} else {
					alpha.add(str.charAt(i));
				}

			} else {
				continue;
			}
		}

		find(0, new int[alpha.size()]);
		System.out.println(max);
	}

	private static int calculate(int[] sel) {
		Queue<Character> q = new ArrayDeque<>();
		q.add('+');
		for(int i = 0; i < str.length(); i++) {
			q.add(str.charAt(i));
		}
		
		int sum = 0;
		char sign = '+';
		while(!q.isEmpty()) {
			sign = q.poll();
			char tmp;
			int num;
			switch (sign) {
			
			
			case '+':
				tmp = q.poll();
				num = value[tmp - 'a'];
				sum += num;
				break;
			case '-' :
				tmp = q.poll();
				num = value[tmp - 'a'];
				sum -= num;
				break;
			case '*' :
				tmp = q.poll();
				num = value[tmp - 'a'];
				sum *= num;
				break;
				
			default:
				break;
			}
		}
		return sum;
		
	}

	static int[] arr = { 1, 2, 3, 4 };

	private static void find(int k, int[] sel) {
		if (k == sel.length) {
			// System.out.println(Arrays.toString(sel));
			for(int i = 0; i < sel.length; i++) {
				char ch = alpha.get(i);
				value[ch - 'a'] = sel[i];
			}
			
			max = Math.max(max, calculate(sel));
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			sel[k] = arr[i];
			find(k+1, sel);
		}
	}

}
