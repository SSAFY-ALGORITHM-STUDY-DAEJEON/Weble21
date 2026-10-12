package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class prim {
	static int V;
	static int E;
	static ArrayList<Vertex>[] adj;
	static class Vertex{
		int e,w;
		Vertex(int e, int w){
			this.e = e;
			this.w = w;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 11 "
				+ "0 1 2 "
				+ "0 2 4 "
				+ "0 5 8 "
				+ "1 2 1 "
				+ "2 5 5 "
				+ "1 3 19 "
				+ "3 5 11 "
				+ "3 4 7 "
				+ "4 6 3 "
				+ "3 6 15 "
				+ "5 4 9 ");
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList();
		}
		// 그래프구현 mst는 (무방향 외? 트리니까)
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			adj[a].add(new Vertex(b, c));
			adj[b].add(new Vertex(a, c));
		}
		// 각정점의 트리포함여부 배열
		boolean[] v = new boolean[V];
		// 각정점까지의 간선의값
		int[] dist = new int[V];
		// 거리배열의 초기값을 무한대로 한다
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 임의의 정점을 선택한다 관습적으로 0을 선택
		dist[0] = 0;
		
		// 선택된 정점과 연결된 간선의 값을 거리배열에 업데이트한다
		for(int cnt = 0; cnt < V-1 ; cnt++){
			// 선택된 정점은 거리배열의 값이 최소인 정점
			int minD = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int i = 0; i < dist.length; i++) {
				// 기준정점 역활을 하지안은 정점중에 타겟정점 까지의 간선비용이 이전비용보다 작다면
				if(!v[i] && dist[i] < minD) {
					minIdx = i;
					minD = dist[i];
				}
			}
			// minIdx 은 방문할수 있는 정점중 간선의 값이 가장작은 정점 (기준정점)
			v[minIdx] = true;
			// 기준정점과 연결된 점정의 간선값을 거리배열에 있는 값보다 작다면 업데이트한다
			for (Vertex target : adj[minIdx]) {
				if(!v[target.e] && target.w < dist[target.e]) {
					dist[target.e] = target.w;
				}
			}
			
		}
		System.out.println(Arrays.toString(dist));

	}

}
