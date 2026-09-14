package Solution;

import java.io.*;
import java.util.*;

public class 기출_하강모의실험 {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tmp = down(arr);
		System.out.println(tmp);

	}

	private static int down(int[][] arr) {
		int cur = 0;
		int result = 0;
		for (int i = 0; i < n; i++) {
			int power = arr[cur][i];
			if(power == 0) {
				continue;
			}
			int k = 1;
			while(true) {
				if(arr[cur+k][i] == 1) {
					cur = cur+k;
					power++;
				} else {
					break;
				}
			}
			//초기 값 계산 끝
			for(int j = cur + 1; j < n; j++) {
				if(arr[j][i] == 0) {
					power *= 1.9;
				} else {
					// 맞닿은 곳 무게 몇인지 계산
					int tmpPower = 0;
					k = 1;
					while(true) {
						if(arr[j+k][i] == 1) {
							k++;
							tmpPower++;
						} else {
							break;
						}
					}
					// 현재 힘이 더 크면
					if(tmpPower < power) {
						power = power + tmpPower;
						cur = cur + k;
					} else {
						// 다음이 더 크면
						break;
					}
				}
				if(j == n - 1) {
					result++;
				}
			}
			
		}
		return result;

	}
}
