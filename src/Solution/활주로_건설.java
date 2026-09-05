package Solution;

import java.io.*;
import java.util.*;

public class 활주로_건설 {
	static int x;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			String nx = bf.readLine();
			StringTokenizer nxst = new StringTokenizer(nx);
			n = Integer.parseInt(nxst.nextToken());
			x = Integer.parseInt(nxst.nextToken());
			int[][] arr = new int[n][n];
			int[] col = new int[n];
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			//가로 검사
			for (int i = 0; i < n; i++) {
				if (check(arr[i])) {
					cnt++;
					//System.out.println(i);
				}
			}
			
			//세로 검사
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					col[j] = arr[j][i];
				}
				if (check(col)) {
					cnt++;
					//System.out.println(i);
				}
			}
			System.out.println("#" + t + " " + cnt);
		}

	}

	private static boolean check(int[] arr) {
		
		boolean[] chk = new boolean[n];
		for (int i = 0; i < arr.length - 1; i++) {
			// 뒤가 더 작으면 뒤에 x 만큼 검사
			if (arr[i] > arr[i + 1]) {
				// 높이 차이가 2 이상이면 바로 종료
				if (arr[i] - arr[i + 1] >= 2)
					return false;
				// x 만큼 탐색
				for (int j = 0; j < x; j++) {
					// 범위 검사
					if (i + j + 1 >= n)
						return false;
					// 이미 경사로가 놓여있는지 확인
					if(chk[i+j+1])
						return false;
					// x만큼 평지인지 확인
					if (arr[i + j + 1] != arr[i + 1]) {
						return false;
					} else {
						chk[i+j+1] = true;
					}
				}
				// 뒤가 더 크면 앞에 x 만큼 검사
			} else if (arr[i] < arr[i + 1]) {
				// 높이 차이가 2 이상이면 바로 종료
				if (arr[i + 1] - arr[i] >= 2)
					return false;
				// x 만큼 탐색
				for (int j = 0; j < x; j++) {
					// 범위 검사
					if (i - j < 0)
						return false;
					// 이미 경사로가 놓여있는지 확인
					if(chk[i - j])
						return false;
					// x만큼 평지인지 확인
					if (arr[i - j] != arr[i]) {
						return false;
					} else {
						chk[i-j] = true;
					}
				}
			} else {
				continue;
			}
		}
		return true;
	}
}
