package Solution;

import java.io.*;
import java.util.*;

public class 하나로 {
	static int[] arr_x;
	static int[] arr_y;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			arr_x = new int[n];
			arr_y = new int[n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				arr_x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				arr_y[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(bf.readLine());
			double E = Double.parseDouble(st.nextToken());

			boolean[] visited = new boolean[n];
			long[] minEdge = new long[n];

			Arrays.fill(minEdge, Long.MAX_VALUE);
			minEdge[0] = 0;

			long result = 0;

			for (int i = 0; i < n; i++) {
				int minV = -1;
				long min = Long.MAX_VALUE;

				// 간선 작은거 선택
				for (int j = 0; j < n; j++) {
					if (!visited[j] && minEdge[j] < min) {
						min = minEdge[j];
						minV = j;
					}
				}

				visited[minV] = true;
				result += min;

				// 새롭게 선택한 정점 기준으로 거리 갱신
				for (int j = 0; j < n; j++) {
					if (!visited[j]) {
						long dist = distance(arr_x[minV], arr_x[j], arr_y[minV], arr_y[j]);

						if (dist < minEdge[j]) {
							minEdge[j] = dist;
						}

					}

				}
			}

			long answer = Math.round(result * E);

			System.out.println("#" + t + " " + answer);

		}
	}

	public static long distance(int x1, int x2, int y1, int y2) {
		long dx = x1 - x2;
		dx = dx * dx;
		long dy = y1 - y2;
		dy = dy * dy;
		return dx + dy;
	}
}