package codeTree;

import java.util.*;

public class 코드트리_순열만들기 {
	static int n;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        int[] arr = new int[n];
        for(int i = 1; i<=n; i++) {
        	arr[i-1] = i;
        }
        recursive(arr, new int[n], 0, new boolean[n]);
    }

	private static void recursive(int[] arr, int[] sel, int k, boolean[] v) {
		// basis part
		if(k == sel.length) {
			for(int i = 0; i< sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// inductive part
		
		for(int i = n-1; i >= 0; i--) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				recursive(arr, sel, k+1, v);
				v[i] = false;
			}
			
			
			
		}
	}
}
