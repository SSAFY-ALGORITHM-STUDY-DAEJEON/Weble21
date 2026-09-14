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
				for(int j = 0; j < cnt; j++) {
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
		// 선수 과목 없으면 바로 수강 가능
		for(int i = 1; i <= n; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		int semester = 0;
		int completed = 0;
		while(!q.isEmpty()) {
			// 이번에 수강할 과목 고정
			int size = q.size();
			semester++;
			
			for(int i = 0; i < size; i++) {
				int cur = q.poll();
				completed++;
				for(int j = 0; j < graph[cur].size(); j++) {
					int next = graph[cur].get(j);
					indegree[next]--;
					
					if(indegree[next] == 0) {
						q.offer(next);
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
