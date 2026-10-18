package Solution;

import java.io.*;
import java.util.*;

public class 키순서 {
	static int n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			m = Integer.parseInt(bf.readLine());
			ArrayList<Integer>[] arr = new ArrayList[n+1];
			ArrayList<Integer>[] reverse = new ArrayList[n+1];
			
			for(int i = 0; i <= n; i++) {
				arr[i] = new ArrayList<>();
				reverse[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < m; i++) {
				int a, b;
				StringTokenizer st = new StringTokenizer(bf.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				arr[a].add(b);
				reverse[b].add(a);
			}
			
			int result = 0;
			for(int i = 1; i <= n; i++) {
				int cnt = dfs(i, arr);
				int cnt_reverse = dfs(i, reverse);
				if(cnt + cnt_reverse == n - 1) {
					result++;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
		
	}

	private static int dfs(int idx, ArrayList<Integer>[] arr) {
		Deque<Integer> dq = new ArrayDeque<>();
		
		int cnt = 0;
		boolean[] v = new boolean[n+1];
		v[idx] = true;
		for(int i = 0; i < arr[idx].size(); i++) {
			dq.addLast(arr[idx].get(i));
			v[arr[idx].get(i)] = true;
			cnt++;
		}
		while(!dq.isEmpty()) {
			int cur = dq.pollLast();
			for(int i = 0; i < arr[cur].size(); i++) {
				if(!v[arr[cur].get(i)]) {
					dq.addLast(arr[cur].get(i));
					v[arr[cur].get(i)] = true;
					cnt++;
				}
				
			}
		}
		
		
		return cnt;
	}
}
