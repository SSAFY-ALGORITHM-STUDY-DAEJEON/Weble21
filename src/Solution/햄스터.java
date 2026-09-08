package Solution;

import java.io.*;
import java.util.*;

public class 햄스터 {
	static int[] room;
	static int[] arr;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n, x, m;
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[x+1];
			for (int i = 0; i <= x; i++) {
				arr[i] = i;
			}
			room = new int[n];
			list = new ArrayList<>();
			recursive(0);
			for (int i = 0; i < m; i++) {
				str = bf.readLine();
				st = new StringTokenizer(str);
				int l, r, s;
				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				for(int j = list.size() - 1; j >= 0 ; j--) {
					if(!check(l, r, s, j)) {
						list.remove(j);
					}
				}
			}
			int length = list.size();
			int max = 0;
			for(int i = 0; i<length; i++) {
				int tmp =sumArr(list.get(i));
				max = Math.max(max, tmp);
			}
			for(int j = list.size() - 1; j >= 0 ; j--) {
				if(sumArr(list.get(j)) != max) {
					list.remove(j);
				}
			}
			
			System.out.print("#" + t + " ");
			
			if(list.isEmpty()) {
				System.out.print("-1");
			} else {
				for(int i = 0; i<list.get(0).length; i++) {
					System.out.print(list.get(0)[i] + " ");
				}
			}
			System.out.println();
			

		}
	}
	
	static int sumArr(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static void recursive(int k) {
		// basis
		if (k == room.length) {
			list.add(room.clone());
			return;
		}

		// inductive
		for (int i = 0; i < arr.length; i++) {
			room[k] = arr[i];
			recursive(k + 1);
		}

	}

	private static boolean check(int l, int r, int s, int cur) {
		int sum = 0;
		for(int i = l - 1; i <= r - 1; i++) {
			sum += list.get(cur)[i];
		}
		if(sum == s) {
			return true;
		} else {
			return false;
		}
		
	}
}
