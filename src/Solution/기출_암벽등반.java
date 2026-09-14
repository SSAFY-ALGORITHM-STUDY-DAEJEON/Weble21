package Solution;

import java.io.*;
import java.util.*;

public class 기출_암벽등반 {
	static int n, m;
	static int[][] arr;
	static int[][] dist;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] start;
	static int[] end;

	public static class Climb {
		int x;
		int y;
		int diff;

		Climb(int x, int y, int diff) {
			this.x = x;
			this.y = y;
			this.diff = diff;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			dist = new int[n][m];
			start = new int[2];
			end = new int[2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
					if (arr[i][j] == 3) {
						end[0] = i;
						end[1] = j;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[start[0]][start[1]] = 0;
			dijkstra();
			
			System.out.println("#" + t + " " + dist[end[0]][end[1]]);
		}
	}

	private static void dijkstra() {
		PriorityQueue<Climb> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
		pq.add(new Climb(start[0], start[1], 0));

		while (!pq.isEmpty()) {
			Climb cur = pq.poll();
			if(dist[cur.x][cur.y] < cur.diff) continue;
			
			for (int d = 0; d < 4; d++) {	
				int cnt = 0;
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				// d == 0, 1 세로 이동
				// d == 2, 3 가로 이동
				if(d == 2 || d == 3) {
					if(arr[nx][ny] == 0) {
						continue;
					} else {
						cnt = cur.diff;
						if(dist[nx][ny] <= cnt) {
							continue;
						}
						pq.add(new Climb(nx, ny, cnt));
						dist[nx][ny] = cnt;
						continue;
					}
				} else if(d == 0) {
					// 올라가기
					for(int i = nx; i < n; i++) {
						if(arr[i][ny] != 0) {
							nx = i;
							cnt++;
							cnt = Math.max(cnt, cur.diff);
							
							if(dist[nx][ny] <= cnt) {
								break;
							}
							
							pq.add(new Climb(nx, ny, cnt));
							dist[nx][ny] = cnt;
							break;
						} else {
							cnt++;
						}
					}
				} else if(d == 1) {
					// 내려가기
					for(int i = nx; i >= 0; i--) {
						if(arr[i][ny] != 0) {
							nx = i;
							cnt++;
							cnt = Math.max(cnt, cur.diff);
							
							if(dist[nx][ny] <= cnt) {
								break;
							}
							
							pq.add(new Climb(nx, ny, cnt));
							dist[nx][ny] = cnt;
							break;
						} else {
							cnt++;
						}
					}
				}
				
				
				
			}
		}

	}
}
