package Solution;

import java.util.*;
import java.io.*;

public class 작업순서 {
	static int v, e;
	static ArrayList<Integer>[] graph;
	static int[] indegree;
	static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			graph = new ArrayList[v + 1];
			indegree = new int[v + 1];
			for (int i = 1; i <= v; i++) {
				graph[i] = new ArrayList<>();
			}
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < e; i++) {
				int pre = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				graph[pre].add(a);
				indegree[a]++;
			}
			indegree[0] = Integer.MAX_VALUE;
			result = new ArrayList<>();
//			System.out.println(Arrays.toString(indegree));
			sort();
			System.out.print("#" + t + " ");
			for(int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i) + " ");
			}
			System.out.println();
			
		}

	}
	
	private static void sort() {
		
		Queue<Integer> q = new ArrayDeque<>();
		// 선 작업 없음
		for (int i = 0; i <= v; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				result.add(cur);
				
				for(int next : graph[cur]) {
					indegree[next]--;
					
					if(indegree[next] == 0) {
						q.add(next);
					}
				}
			}
		}
		
	}
}
