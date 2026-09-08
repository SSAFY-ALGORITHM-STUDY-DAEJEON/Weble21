package Solution;

import java.io.*;
import java.util.*;

public class 수제버거장인 {
	static int n, m;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			cnt = 0;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}
			ArrayList<Integer>[] list = new ArrayList[n + 1];
			for(int i = 0; i<n+1; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				str = bf.readLine();
				st = new StringTokenizer(str);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			recursive(0, new ArrayList<Integer>(), list, arr);
			System.out.println("#" + " " + t + " " + cnt);

		}
	}

	private static void recursive(int idx, ArrayList<Integer> sel, ArrayList<Integer>[] list, int[] arr) {
		// basis part
		if(idx == n) {
			//System.out.println(sel);
			cnt++;
			return;
		}
		
		// inductive part
		int cur = arr[idx];
		boolean able = true;
		// 겹치는 재료인지 확인
		for(int i = 0; i < sel.size(); i++) {
			// 재료 겹침
			if(list[sel.get(i)].contains(cur)) {
				able = false;
				break;
			} else {
				continue;
			}
		}
		
		
		if(able) {
			sel.add(cur);
			//선택함
			recursive(idx+1, sel, list, arr);
			sel.remove(sel.size() - 1);
		}
		//선택안함
		recursive(idx+1, sel, list, arr);
		
		
	}
}
