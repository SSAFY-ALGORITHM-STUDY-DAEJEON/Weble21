package Solution;

import java.io.*;
import java.util.*;

public class 극장좌석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		int j = 0;
		int sum = 1;
		for(int k = 0; k < m; k++) {
			int tmp = Integer.parseInt(bf.readLine());
			int cnt = 0;
			while(true) {
				j++;
				if(j == tmp) {
					break;
				}
				cnt++;
			}
			//System.out.println(dp[cnt]);
			sum *= dp[cnt];
		}
		//System.out.println(dp[n-j]);
		sum *= dp[n - j];
		if(n == m) {
			sum = 1;
		}
		System.out.println(sum);
	}
}
