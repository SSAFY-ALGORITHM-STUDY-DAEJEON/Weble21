package Solution;

import java.io.*;
import java.util.*;

public class 색종이붙이기 {
	static int n = 10;
	static int cnt;
	static int min;
	static int[] remain = {0, 5, 5, 5, 5, 5};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[n][n];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(arr, 0, 0);
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	private static void recursive(int[][] arr, int x, int y) {
		// basis part
		if(cnt >= min) return;
			
		// inductive part
		for(int i = x; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1) {
					
					if(can(1, arr, i, j)) {
						paper(1, arr, i, j);
						recursive(arr, i, j);
						rollback(1, arr, i, j);
					}
					
					if(can(2, arr, i, j)) {
						paper(2, arr, i, j);
						recursive(arr, i, j);
						rollback(2, arr, i, j);
					}
					
					if(can(3, arr, i, j)) {
						paper(3, arr, i, j);
						recursive(arr, i, j);
						rollback(3, arr, i, j);
					}
					if(can(4, arr, i, j)) {
						paper(4, arr, i, j);
						recursive(arr, i, j);
						rollback(4, arr, i, j);
					}
					
					if(can(5, arr, i, j)) {
						paper(5, arr, i, j);
						recursive(arr, i, j);
						rollback(5, arr, i, j);
					}
					
					return;
					
				}
			}
		}
		
		min = Math.min(min, cnt);
	}

	private static void rollback(int k, int[][] arr, int x, int y) {
		// 백트래킹으로 다시 원상복귀
				for(int i = x; i < x + k; i++) {
					for(int j = y; j < y + k; j++) {
						arr[i][j] = 1;
					}
				}
				
				remain[k]++;
				cnt--;
		
	}

	private static void paper(int k, int[][] arr, int x, int y) {
		// 종이 붙이기
		for(int i = x; i < x + k; i++) {
			for(int j = y; j < y + k; j++) {
				arr[i][j] = 0;
			}
		}
		
		remain[k]--;
		cnt++;
	}

	private static boolean can(int k, int[][] arr, int x, int y) {
		// 종이 남았는지
		if(remain[k] == 0) {
			return false;
		}
		
		// 색종이 범위 체크
		if(x + k > n || y + k > n) {
			return false;
		}
		
		// 덮을 수 있는 영역인지 확인
		for(int i = x; i < x + k; i++) {
			for(int j = y; j < y + k; j++) {
				if(arr[i][j] != 1) {
					return false;
				}
			}
		}
		
		return true;
	}
}







