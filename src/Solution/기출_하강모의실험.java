package Solution;

import java.io.*;
import java.util.*;

public class 기출_하강모의실험 {
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int tmp1 = down();
			int tmp2 = right();
			System.out.println("#" + tc + " " + tmp1 + " " + tmp2);
		}
		

	}
	
	
	private static int right() {
		for (int i = 0; i < n; i++) {
			int cur = 0;
			int cnt = 1;
			int power = arr[cur][i];
			if(power == 0) {
	
				continue;
			}
			
			while(cur + 1 < n) {
				// 다음이 0
				if(arr[i][cur+1] == 0) {
					arr[i][cur-cnt+1] = 0;
					arr[i][cur+1] = 1;
					cur++;
					power *= 1.9;
				} else {
					// 다음이 1
					int tmpPower = 0;
					int k = cur + 1;
					while(k < n && arr[i][k] == 1) {
						k++;
						tmpPower++;
					}
					if(tmpPower >= power) {
						break;
					}
					power += tmpPower;
					cnt += tmpPower;
					cur = k - 1;
				}
			}
		}
		int result = 0;
		for(int i = 0; i<n; i++) {
			if(arr[i][n-1] == 1) {
				result++;
			}
		}
		return result;
	}



	private static int down() {
		for(int i = 0; i < n; i++) {
			int cur = 0;
			int cnt = 1;
			double power = 1;
			if(arr[cur][i] == 0) {
				continue;
			}
			
			while(cur + 1 < n) {
				// 다음이 0일때
				if(arr[cur+1][i] == 0) {
					arr[cur-cnt+1][i] = 0;
					arr[cur+1][i] = 1;
					cur++;
					power *= 1.9;
				} else {
					// 다음이 1일때
					int tmpPower = 0;
					int k = cur + 1;
					while(k < n && arr[k][i] == 1) {
						tmpPower++;
						k++;
					}
					if(tmpPower >= power) {
						break;
					}
					power += tmpPower;
					cnt += tmpPower;
					cur = k - 1;
				}
			}
		}
		int result = 0;
		for(int i = 0; i<n; i++) {
			if(arr[n-1][i] == 1) {
				result++;
			}
		}
		return result;
	}

	
}
