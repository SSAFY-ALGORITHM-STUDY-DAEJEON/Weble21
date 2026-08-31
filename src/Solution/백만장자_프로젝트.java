<<<<<<< HEAD
package Solution;

import java.io.*;
import java.util.*;

public class 백만장자_프로젝트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int max = 0;
			for(int i = 0; i <  n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			ArrayList<Integer> list = new ArrayList<>();
			long sum = 0;
			for(int i = 0; i < n-1; i++) {
				if(arr[i] < max) {
					list.add(arr[i]);
				} else {
					while(!list.isEmpty() ) {
						int tmp = list.get(0);
						list.remove(0);
						sum = sum + arr[i] - tmp;
					}
					max = 0;
					for(int j = i+1; j < n; j++) {
						max = Math.max(max, arr[j]);
					}
				}				
			}
			if(!list.isEmpty()) {
				while(!list.isEmpty() ) {
					int tmp = list.get(0);
					list.remove(0);
					sum = sum + arr[n-1] - tmp;
				}
			}
			System.out.println("#" + t + " " + sum);
			
		}
	}
}
=======
package Solution;

import java.io.*;
import java.util.*;

public class 백만장자_프로젝트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int max = 0;
			for(int i = 0; i <  n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			ArrayList<Integer> list = new ArrayList<>();
			long sum = 0;
			for(int i = 0; i < n-1; i++) {
				if(arr[i] < max) {
					list.add(arr[i]);
				} else {
					while(!list.isEmpty() ) {
						int tmp = list.get(0);
						list.remove(0);
						sum = sum + arr[i] - tmp;
					}
					max = 0;
					for(int j = i+1; j < n; j++) {
						max = Math.max(max, arr[j]);
					}
				}				
			}
			if(!list.isEmpty()) {
				while(!list.isEmpty() ) {
					int tmp = list.get(0);
					list.remove(0);
					sum = sum + arr[n-1] - tmp;
				}
			}
			System.out.println("#" + t + " " + sum);
			
		}
	}
}
>>>>>>> 6d3dbf7 (활주로 문제)
