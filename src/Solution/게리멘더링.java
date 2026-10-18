package Solution;

import java.io.*;
import java.util.*;

/*
 * 시간 복잡도 : O(2ⁿ × n³)
 * 2¹⁰ × 10³ = 1,024,000
 * 공간 복잡도 : O(n²)
 * 
 * */

public class 게리멘더링 {
	static ArrayList<Integer> group_a;
	static ArrayList<Integer> group_b;
	static ArrayList<Integer>[] arr;
	static int[] people;
	static int min = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		people = new int[n + 1];
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		// 인구 수 입력
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		arr = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		// 그래프
		for (int i = 1; i <= n; i++) {
			str = bf.readLine();
			st = new StringTokenizer(str);
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i].add(tmp);
				arr[tmp].add(i);

			}
		}
		int[] city = new int[n+1];
		for (int i = 1; i <= n; i++) {
			city[i] = i;
		}

		divid(city, 1, new boolean[city.length], 0);
		
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}

		System.out.println(min);

	}

	private static void divid(int[] city, int idx, boolean[] sel, int k) {
		// basis part
		if (idx == city.length) {
			if (k == 0 || k == city.length - 1) {
				return;
			}

			group_a = new ArrayList<>();
			group_b = new ArrayList<>();
			
			for (int i = 1; i < city.length; i++) {
				if (sel[i]) {
					group_a.add(city[i]);
				} else {
					group_b.add(city[i]);
				}
			}

//			System.out.println(group_a);
//			System.out.println(group_b);

			if (dfs_check(group_a) && dfs_check(group_b)) {
				// 다 연결 그래프이면
				int tmp = calculate(group_a, group_b);
				min = Math.min(tmp, min);
				return;
			} else {
				return;
			}

		}

		// inductive part
		// 선택한 경우
		sel[idx] = true;
		divid(city, idx + 1, sel, k + 1);
		// 선택 X
		sel[idx] = false;
		divid(city, idx + 1, sel, k);
	}

	private static int calculate(ArrayList<Integer> group_a, ArrayList<Integer> group_b) {
		// 인구수 계산
		int sum_a = 0;
		for (int i = 0; i < group_a.size(); i++) {
			sum_a += people[group_a.get(i)];
		}

		int sum_b = 0;
		for (int i = 0; i < group_b.size(); i++) {
			sum_b += people[group_b.get(i)];
		}

		int result = Math.abs(sum_a - sum_b);

		return result;

	}

	private static boolean dfs_check(ArrayList<Integer> group) {
		// 그래프 확인
		int cnt = 0;
		Stack<Integer> s = new Stack<>();
		boolean[] v = new boolean[n + 1];
		s.push(group.get(0));
		v[group.get(0)] = true;
		cnt++;
		while (!s.isEmpty()) {
			int cur = s.pop();
			// group에 있으면
			if (group.contains(cur)) {
				for (int d = 0; d < arr[cur].size(); d++) {
					if (!v[arr[cur].get(d)] && group.contains(arr[cur].get(d))) {
						s.push(arr[cur].get(d));
						v[arr[cur].get(d)] = true;
						cnt++;
					}

				}

			} else {
				// group에 없으면
				continue;
			}
		}
		if (cnt == group.size()) {
			return true;
		} else {
			return false;
		}
	}
}
