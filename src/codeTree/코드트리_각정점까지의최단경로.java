package codeTree;

import java.util.*;

public class 코드트리_각정점까지의최단경로 {
	public static class Edge {
		int node;
		int value;

		Edge(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}

	static int n, m, k;
	static ArrayList<Edge>[] arr;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		arr = new ArrayList[n + 1];
		for(int i = 0; i < n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			arr[u].add(new Edge(v, w));
			arr[v].add(new Edge(u, w));
		}

		dijkstra(k);
		for(int i = 1; i<=n; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(dist[i]);
			}
			
		}
	}

	private static void dijkstra(int k) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[k] = 0;
		pq.add(new Edge(k, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curNode = cur.node;
			int curValue = cur.value;

			if (curValue > dist[curNode]) {
				continue;
			}

			for (int i = 0; i < arr[curNode].size(); i++) {
				Edge next = arr[curNode].get(i);
				int nextDist = curValue + next.value;
				
				if(nextDist >= dist[next.node]) continue;
				
				dist[next.node] = nextDist;
				pq.add(new Edge(next.node, nextDist));
				
			}

		}

	}
}
