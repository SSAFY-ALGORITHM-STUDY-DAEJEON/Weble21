package Solution;

import java.io.*;
import java.util.*;

public class 기출_수강신청 {
	static int n;
	static ArrayList<Integer>[] graph;
	static int[] indegree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(bf.readLine());
			graph = new ArrayList[n + 1];
			indegree = new int[n + 1];
			
			for(int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			for(int subject = 1; subject <= n; subject++) {
				String str = bf.readLine(); 
				StringTokenizer st = new StringTokenizer(str);
				int cnt = Integer.parseInt(st.nextToken());
				indegree[subject] = cnt;
				for(int i = 0; i < cnt; i++) {
					int pre = Integer.parseInt(st.nextToken());
					graph[pre].add(subject);
				}
				
				
			}
			int answer = sort();
			System.out.println("#" + t + " " + answer);
		}
	}

	private static int sort() {
		Queue<Integer> q = new ArrayDeque<>();
		// 선수과목 없음
		for(int i = 1; i <= n; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		int semester = 0;
		int completed = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			semester++;
			
			for(int i = 0; i < size; i++) {
				int cur = q.poll();
				completed++;
				for(int next : graph[cur]) {
					indegree[next]--;
					
					if(indegree[next] == 0) {
						q.add(next);
					}
				}
			}
		}
		if(completed != n) {
			return -1;
		}
		return semester;
		
		
	}
}
