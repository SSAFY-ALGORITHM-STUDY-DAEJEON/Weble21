package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			String res = bf.readLine();
			int[] arr = new int[res.length()];
			
			int cnt = 0;
			for(int i = 0; i < res.length(); i++) {
				arr[i] = res.charAt(i) - '0';
			}
			int[] change = new int[arr.length];
			for(int i = 0; i< arr.length; i++) {
				if(arr[i] != change[i]) {
					if(arr[i] == 1) {
						for(int j = i; j < change.length; j++) {
							change[j] = 1;
						}
					} else {
						for(int j = i; j < change.length; j++) {
							change[j] = 0;
						}
					}
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
