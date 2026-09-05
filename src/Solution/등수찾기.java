package Solution;


import java.io.*;
import java.util.*;

public class 등수찾기 {
	static int n, m;
	static ArrayList<Integer>[] arr;
	static ArrayList<Integer>[] reverse;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String nmx = bf.readLine();
		StringTokenizer nmxst = new StringTokenizer(nmx);
		n = Integer.parseInt(nmxst.nextToken());
		m = Integer.parseInt(nmxst.nextToken());
		int x = Integer.parseInt(nmxst.nextToken());
		
		// ArrayList 선언 및 초기화
		arr = new ArrayList[n+1];
		reverse = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) {
			arr[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		
		// 그래프 그리기
		for(int t = 0; t<m; t++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b].add(a);
			reverse[a].add(b);			
		}
		
		int top = dfs(arr, x);
		int btm = dfs(reverse, x);
		top += 1;
		btm = n - btm;
		System.out.println(top + " " + btm);
		
	}


	private static int dfs(ArrayList<Integer>[] arr, int idx) {
		Deque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		visited[idx] = true;
		int cnt = 0;
		for(int i = 0; i < arr[idx].size(); i++) {
			dq.offerLast(arr[idx].get(i));
			visited[arr[idx].get(i)] = true;
			cnt++;
		}
		while(!dq.isEmpty()) {
			int tmp = dq.pollLast();
			
			for(int i = 0; i < arr[tmp].size(); i++) {
				if(visited[arr[tmp].get(i)]) {
					continue;
				}
				dq.offerLast(arr[tmp].get(i));
				visited[arr[tmp].get(i)] = true;
				cnt++;
			}
		}
				
		return cnt;
	}
}
