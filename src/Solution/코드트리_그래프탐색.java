package Solution;

import java.util.*;
import java.io.*;

public class 코드트리_그래프탐색 {
	static ArrayList<Integer> result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		for(int i = 0; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int node = sc.nextInt();
			int v = sc.nextInt();
			arr[node].add(v);
		}
		result = new ArrayList<>();
		boolean[] v = new boolean[n+1];
		dfs(arr, 1, v);
		
		System.out.println(result.size());
	}
	public static void dfs(ArrayList<Integer>[] arr, int k, boolean[] v) {
		int cur = k;
		Stack<Integer> s = new Stack<>();
		s.push(cur);
		v[cur] = true;
		while(!s.empty()) {
			cur = s.pop();
			for(int i = 0; i<arr[cur].size(); i++) {
				int tmp = arr[cur].get(i);
				if(v[tmp]) {
					continue;
				}
				v[tmp] = true;
				result.add(tmp);
				s.push(tmp);
			}
		}
	}
	
}
