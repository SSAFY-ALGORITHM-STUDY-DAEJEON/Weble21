package codeTree;

import java.util.*;

public class 코드트리_피보나치수 {
	static int[] dp = new int[46];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 0; i < dp.length; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        
        
        System.out.println(dp[n]);
    }
}
