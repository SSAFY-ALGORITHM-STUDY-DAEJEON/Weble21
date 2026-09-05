package Solution;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 최소_스패닝_트리 {
	static int v, e;
	static int[] sets;
	static Node[] arr;
	static class Node {
		int start;
		int end;
		int value;
		
		public Node(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for(int t = 1; t <= tc; t++) {
			String ve = bf.readLine();
			StringTokenizer stve = new StringTokenizer(ve);
			v = Integer.parseInt(stve.nextToken());
			e = Integer.parseInt(stve.nextToken());
			sets = new int[v+1];
			for(int i = 1; i <= v; i++) {
				sets[i] = i;
			}
			arr = new Node[e];
			for(int i = 0; i<e; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				Node node = new Node(a, b, c);
				arr[i] = node;				
			}
			Arrays.sort(arr, Comparator.comparing(n -> n.value));
			// System.out.println(Arrays.toString(arr));
			long result = kruskal();
			
			System.out.println("#" + t + " " + result);
			
			
		}
	}
	
	static long kruskal() {
		long cost = 0;
		int cnt = 0;
		for (Node node : arr) {
			int first = findSet(node.start);
			int second = findSet(node.end);
			if(sets[first] != sets[second]) {
				union(first, second);
				cost += node.value;
				cnt++;
			} else {
                continue;
            }
			if(cnt == v-1) return cost;
		}
		
		return cost;
	}
	
	private static void union(int a, int b) {
		int first = findSet(a);
		int second = findSet(b);
		if(first != second) {
			sets[second] = first;
		}
	}

	private static int findSet(int a) {
		if(sets[a] == a) {
			return a;
		}
		else {
			return sets[a] = findSet(sets[a]);
		}
	}
	

	
}

