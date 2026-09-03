package Solution;

import java.io.*;
import java.util.*;

public class 탈주범_검거 {
	static int n, m, r, c, l;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] arr;
	static int[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(bf.readLine());

		for (int t = 1; t <= tc; t++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			visited = new int[n][m];
			for (int i = 0; i < n; i++) {
				String sstr = bf.readLine();
				StringTokenizer sst = new StringTokenizer(sstr);
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(sst.nextToken());
				}
			}
			bfs(r, c);
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(visited[i][j] != 0 && visited[i][j] < l) {
						result++;
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
			

			
		}

	}

	private static void bfs(int r, int c) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offerLast(new int[] { r, c });
		visited[r][c] = 1;
		// cur[0] = r, cur[1] = c
		while(!dq.isEmpty()) {
			
			int[] cur = dq.pollFirst();
			int tunnel = arr[cur[0]][cur[1]];
			//for문의 순서는 상, 하, 좌, 우
			switch (tunnel) {
			// 1. 상하좌우
			case 1:
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (visited[nr][nc] > 0)
						continue;
					if (i == 0) {
						//상
						if (arr[nr][nc] == 1 || arr[nr][nc] == 2 || arr[nr][nc] == 5 || arr[nr][nc] == 6) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 1) {
						//하
						if (arr[nr][nc] == 1 || arr[nr][nc] == 2 || arr[nr][nc] == 7 || arr[nr][nc] == 4) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 2) {
						//좌
						if (arr[nr][nc] == 1 || arr[nr][nc] == 3 || arr[nr][nc] == 5 || arr[nr][nc] == 4) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 3) {
						//우
						if (arr[nr][nc] == 1 || arr[nr][nc] == 3 || arr[nr][nc] == 7 || arr[nr][nc] == 6) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
				}
				break;

				// 2. 상, 하
			case 2:
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (visited[nr][nc] > 0)
						continue;
					if (i == 0) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 2 || arr[nr][nc] == 5 || arr[nr][nc] == 6) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 1) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 2 || arr[nr][nc] == 7 || arr[nr][nc] == 4) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 2) {
						continue;
					}
					if (i == 3) {
						continue;
					}
				}
				break;
				// 3. 좌, 우
			case 3:
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					
					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (visited[nr][nc] > 0)
						continue;
					if (i == 0) {
						continue;
					}
					if (i == 1) {
						continue;
					}
					if (i == 2) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 3 || arr[nr][nc] == 5 || arr[nr][nc] == 4) {
							
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 3) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 3 || arr[nr][nc] == 7 || arr[nr][nc] == 6) {
							
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
				}
				break;
				// 4. 상, 우
			case 4:
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (visited[nr][nc] > 0)
						continue;
					if (i == 0) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 2 || arr[nr][nc] == 5 || arr[nr][nc] == 6) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 1) {
						continue;
					}
					if (i == 2) {
						continue;
					}
					if (i == 3) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 3 || arr[nr][nc] == 7 || arr[nr][nc] == 6) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
				}
				break;
				// 5. 하, 우
			case 5:
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (visited[nr][nc] > 0)
						continue;
					if (i == 0) {
						continue;
					}
					if (i == 1) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 2 || arr[nr][nc] == 7 || arr[nr][nc] == 4) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 2) {
						continue;
					}
					if (i == 3) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 3 || arr[nr][nc] == 7 || arr[nr][nc] == 6) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
				}
				break;
				// 6. 하, 좌
			case 6:
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (visited[nr][nc] > 0)
						continue;
					if (i == 0) {
						continue;
					}
					if (i == 1) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 2 || arr[nr][nc] == 7 || arr[nr][nc] == 4) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 2) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 3 || arr[nr][nc] == 5 || arr[nr][nc] == 4) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 3) {
						continue;
					}
				}
				break;
				// 7. 상, 좌
			case 7:
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (visited[nr][nc] > 0)
						continue;
					if (i == 0) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 2 || arr[nr][nc] == 5 || arr[nr][nc] == 6) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 1) {
						continue;
					}
					if (i == 2) {
						if (arr[nr][nc] == 1 || arr[nr][nc] == 3 || arr[nr][nc] == 5 || arr[nr][nc] == 4) {
							dq.offerLast(new int[] { nr, nc });
							visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
						} else {
							continue;
						}
					}
					if (i == 3) {
						continue;
					}
				}
				break;
				
			default:
				break;

			}
			
			
		}
	}

}
