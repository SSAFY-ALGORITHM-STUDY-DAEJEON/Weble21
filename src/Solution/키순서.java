package Solution;

import java.io.*;
import java.util.*;

public class 키순서 {
	static int n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		ArrayList<Integer>[] reverse = new ArrayList[n+1];
		for(int i = 0; i<n+1; i++) {
			arr[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		
		for(int t = 0; t<m; t++) {
			String sstr = bf.readLine();
			StringTokenizer sst = new StringTokenizer(sstr);
			int node = Integer.parseInt(sst.nextToken());
			int destination = Integer.parseInt(sst.nextToken());
			arr[node].add(destination);
			reverse[destination].add(node);
			
		}
		int[] cnt = new int[n+1];
		int result = 0;
		for(int i = 1; i < arr.length; i++) {
			int cnt_a = dfs(i, arr);
			
			int cnt_b = dfs(i, reverse);
			
			if(cnt_a + cnt_b == n-1) {
				result++;
			}
		}
		System.out.println(result);
	}

	private static int dfs(int idx, ArrayList<Integer>[] arr) {
		Deque<Integer> dq = new ArrayDeque<>();
		boolean[] v = new boolean[arr.length];
		v[idx] = true;
		int cnt = 0;
		for(int i = 0; i< arr[idx].size(); i++) {
			dq.offerLast(arr[idx].get(i));
			v[arr[idx].get(i)] = true;
			cnt++;
		}
		while(!dq.isEmpty()) {
			int curIdx = dq.pollLast();
			for(int i = 0; i< arr[curIdx].size(); i++) {
				if(!v[arr[curIdx].get(i)]) {
					dq.offerLast(arr[curIdx].get(i));
					v[arr[curIdx].get(i)] = true;
					cnt++;
				}
				
			}
		}
		return cnt;
	}
}
