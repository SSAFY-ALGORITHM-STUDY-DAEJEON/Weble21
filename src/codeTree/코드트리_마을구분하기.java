package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_마을구분하기 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<int[]> town;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		arr = new int[n][n];
		visited = new boolean[n][n];
		town = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					town.add(new int[] { i, j });
				}
			}
		}
		
		int townCnt = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < town.size(); i++) {
			if (!visited[town.get(i)[0]][town.get(i)[1]]) {
				int people = dfs(town.get(i));
				pq.add(people);
				townCnt++;
			}
		}
		System.out.println(townCnt);
		while(!pq.isEmpty()) {
			int tmp = pq.poll();
			System.out.println(tmp);
		}
		

	}

	private static int dfs(int[] cur) {
		int cnt = 0;
		Stack<int[]> s = new Stack<>();
		s.push(cur);
		visited[cur[0]][cur[1]] = true;
		cnt++;
		while (!s.isEmpty()) {
			cur = s.pop();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				
				if(visited[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] == 0) {
					continue;
				}
				s.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				cnt++;
			}

		}
		return cnt;

	}
}
