package codeTree;

import java.util.*;

public class 코드트리_최단거리9 {
	public static class Node {
		int node;
		int value;
		
		Node(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}
	
	static int[] dist;
	static int[] path;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dist = new int[n];
        path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        ArrayList<Node>[] arr = new ArrayList[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[u-1].add(new Node(v-1, w));
            arr[v-1].add(new Node(u-1, w));
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        dijstra(a-1,b-1,arr);
        
        System.out.println(dist[b-1]);
        ArrayList<Integer> res = new ArrayList<>();
       
        int cur = b-1;
        while(cur != -1) {
        	res.add(cur+1);
        	if(cur == a -1) break;
        	
        	cur = path[cur];
        }
        for(int i = res.size() - 1; i >= 0; i--) {
        	System.out.print(res.get(i) + " ");
        }
	}

	private static void dijstra(int a, int b, ArrayList<Node>[] arr) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
		pq.add(new Node(a, 0));
		dist[a] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.value > dist[cur.node]) {
				continue;
			}
			
			for(int i = 0; i < arr[cur.node].size(); i++) {
				Node next = arr[cur.node].get(i);
				int nextDist = next.value + cur.value;
				
				if(nextDist >= dist[next.node]) {
					continue;
				}
				
				dist[next.node] = nextDist;
				path[next.node] = cur.node; 
				pq.add(new Node(next.node, nextDist));			
				
			}
			
		}
		
	}
}
