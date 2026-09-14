package Solution;

import java.io.*;
import java.util.*;

public class 기출_풍선터트리기 {
	static int n;
	static int arr[];
	static int memo[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		arr = new int[n+2];
		arr[0] = 1;
		arr[n+1] = 1;
		
		for(int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		memo = new int[n + 2][n + 2];
		for(int i = 0; i<n+2; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		System.out.println(recursive(1, n));
		
	}

	private static int recursive(int left, int right) {
		// 없는 구간
		if(left > right) {
			return 0;
		}
		// 이미 계산한 곳
		if(memo[left][right] != -1) {
			return memo[left][right];
		}
		
		int max = 0;
		// k의 풍선 터트리기
		for(int k = left; k <= right; k++) {
			int leftScore = recursive(left, k - 1);
			int rightScore = recursive(k + 1, right);
			int lastScore = arr[left - 1] * arr[k] * arr[right + 1];
			
			max = Math.max(max, leftScore + rightScore + lastScore);
		}
		
		return memo[left][right] = max;
		
		
	}

	
}
