package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class 재관이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i =0; i<n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(arr, (o1, o2) -> o2 - o1);
			int sum = 0;
			for(int i = 0; i < n; i++) {
				if(i % 3 != 2) {
					sum += arr.get(i);
				}
			}
			
			
			System.out.println(sum);
		}
	}
	
	

}
