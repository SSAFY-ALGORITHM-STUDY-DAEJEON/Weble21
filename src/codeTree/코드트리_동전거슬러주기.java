package codeTree;

import java.util.*;

public class 코드트리_동전거슬러주기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		int cnt = 0;
		int r = n -1;
		// Please write your code here.
		while(k != 0) {
			if(k >= coins[r]) {
				k -= coins[r];
				cnt++;
			} else {
				r--;
			}
			
		}
		
		System.out.println(cnt);
	}
}
