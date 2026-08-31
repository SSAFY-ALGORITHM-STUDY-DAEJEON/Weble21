<<<<<<< HEAD
package Solution;

import java.io.*;
import java.util.*;

public class 장애물_경주_난이도 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int up = 0;
			int down = 0;
			
			for(int i = 0; i < n-1; i++) {
				int a = arr[i];
				int b = arr[i+1];
				if(a < b) {
					int tmp = b - a;
					up = Math.max(tmp,  up);
				} else if(a > b) {
					int tmp = a - b;
					down = Math.max(tmp,  down);
				} else {
					continue;
				}
			}
			System.out.println("#" + t + " " + up + " " + down);
			
		}
		
	}
}
=======
package Solution;

import java.io.*;
import java.util.*;

public class 장애물_경주_난이도 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int up = 0;
			int down = 0;
			
			for(int i = 0; i < n-1; i++) {
				int a = arr[i];
				int b = arr[i+1];
				if(a < b) {
					int tmp = b - a;
					up = Math.max(tmp,  up);
				} else if(a > b) {
					int tmp = a - b;
					down = Math.max(tmp,  down);
				} else {
					continue;
				}
			}
			System.out.println("#" + t + " " + up + " " + down);
			
		}
		
	}
}
>>>>>>> 6d3dbf7 (활주로 문제)
