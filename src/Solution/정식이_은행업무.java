package Solution;

import java.io.*;
import java.util.*;

public class 정식이_은행업무 {
	static ArrayList<Long> arr;
	static ArrayList<Long> arr_tri;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String bi = br.readLine();
			String tri = br.readLine();
			arr = new ArrayList<>();
			arr_tri = new ArrayList<>();
			//arr_tri = new ArrayList<>();
			changeBi(bi);
			changeTri(tri);
			
//			System.out.println(arr);
//			System.out.println(arr_tri);
			
			for(int i = 0; i< arr.size(); i++) {
				for(int j = 0; j<arr_tri.size(); j++) {
					if(arr.get(i).equals(arr_tri.get(j))) {
						System.out.println("#" + t + " " + arr.get(i));
					}
				}
			}

		}
	}
	
	static void changeBi(String bi) {
		for (int i = 0; i < bi.length(); i++) {
			char[] tmp = new char[bi.length()];
			for(int j = 0; j<bi.length(); j++) {
				if(i != j) {
					tmp[j] = bi.charAt(j);
				} else {
					if(bi.charAt(i) == '0') {
						tmp[j] = '1';
					} else {
						tmp[j] = '0';
					}
				}
			}
			
			String str = new String(tmp);
			arr.add(Long.parseLong(str, 2));
			
		}
	}
	
	static void changeTri(String tri) {
		for (int i = 0; i < tri.length(); i++) {
			char[] tmp = new char[tri.length()];
			char[] tmp2 = new char[tri.length()];
			for(int j = 0; j<tri.length(); j++) {
				if(i != j) {
					tmp[j] = tri.charAt(j);
					tmp2[j] = tri.charAt(j);
				} else {
					if(tri.charAt(i) == '2') {
						tmp[j] = '1';
						tmp2[j] = '0';
					} else if(tri.charAt(i) == '1') {
						tmp[j] = '2';
						tmp2[j] = '0';
					} else {
						tmp[j] = '2';
						tmp2[j] = '1';
					}
				}
			}
			
			String str = new String(tmp);
			String str2 = new String(tmp2);
			long tri_1 = Long.parseLong(str, 3);
			long tri_2 = Long.parseLong(str2, 3);
			arr_tri.add(tri_1);
			arr_tri.add(tri_2);
			
		}
		
	}
}
