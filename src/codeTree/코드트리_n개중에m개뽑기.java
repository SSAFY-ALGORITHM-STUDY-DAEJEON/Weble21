package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_n개중에m개뽑기 {
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = i + 1;
		}
		recursive(0, new int[m], arr, 0);
	}
	
	private static void recursive(int k, int[] sel, int[] arr, int cur) {
		// basis
		if(k == sel.length) {
			for(int i = 0; i< sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		// inductive
		for(int i = cur; i < arr.length; i++) {
			sel[k] = arr[i];
			recursive(k+1, sel, arr, i+1);
		}
	}
}
