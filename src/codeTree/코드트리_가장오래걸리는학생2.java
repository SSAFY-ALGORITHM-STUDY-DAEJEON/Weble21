package codeTree;

import java.util.*;

public class 코드트리_가장오래걸리는학생2 {
	public static class Node {
		int node;
		int value;
		
		Node(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}
	static int[] distance;
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Node>[] arr = new ArrayList[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            arr[b-1].add(new Node(a-1, d));
        }
        distance = new int[n];
        dijstra(n, arr);
        
        int max = -1;
        for(int i = 0; i < distance.length; i++) {
        	if(max < distance[i]) {
        		max = distance[i];
        	}
        }
        
        System.out.println(max);
        
    }

	private static void dijstra(int n, ArrayList<Node>[] arr) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[n-1] = 0;
		pq.add(new Node(n-1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.value > distance[cur.node]) {
				continue;
			}
			
			for(int i = 0; i < arr[cur.node].size(); i++) {
				Node next = arr[cur.node].get(i);
				int nextDist = cur.value + next.value;
				if(nextDist >= distance[next.node]) {
					continue;
				}
				
				distance[next.node] = nextDist;
				pq.add(new Node(next.node, nextDist));
			}
		}
	}
}
