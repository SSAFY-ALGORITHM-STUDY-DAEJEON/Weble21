package Solution;

import java.io.*;
import java.util.*;

public class 미로탐색 {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static ArrayList<Integer> result;
	static int n, m;	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n + 1];
		result = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			String sstr = bf.readLine();
			StringTokenizer sst = new StringTokenizer(sstr);
			int a = Integer.parseInt(sst.nextToken());
			int b = Integer.parseInt(sst.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(arr[i]);
			// System.out.println(arr[i]);
		}
		
		
		dfs(1);

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}

	}

	static void dfs(int node) {
		Stack<Integer> s = new Stack<>();
		s.push(node);
		visited[node] = true;
		result.addLast(node);
		
		while(!s.isEmpty()) {
			if (result.size() == n) {
				break;
			}
			int cnt = 0;
			node = s.peek();
			for (int i = 0; i < arr[node].size(); i++) {
				if (!visited[arr[node].get(i)]) {
					s.add(arr[node].get(i));
					visited[arr[node].get(i)] = true;
					result.addLast(arr[node].get(i));
					break;
				} else {
					cnt++;
					continue;
				}	
			}
			if(cnt == arr[node].size()) {
				s.pop();
			}
			
		}
	}
}
