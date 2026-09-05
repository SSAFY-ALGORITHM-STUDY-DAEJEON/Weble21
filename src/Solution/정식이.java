package Solution;

import java.io.*;
import java.util.*;

public class 정식이 {
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String bi = br.readLine();
			String tri = br.readLine();
			arr = new ArrayList<>();
			//arr_tri = new ArrayList<>();
			changeBi(bi);
			int result = changeTri(tri);
			
			System.out.println("#" + t + " " + result);

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
			arr.add(Integer.parseInt(str, 2));
			
		}
	}
	
	static int changeTri(String tri) {
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
			int tri_1 = Integer.parseInt(str, 3);
			int tri_2 = Integer.parseInt(str2, 3);
			
			for(int j =0; j<arr.size(); j++) {
				if(arr.indexOf(tri_1) != -1) {
					return arr.get(arr.indexOf(tri_1));
				}
				if (arr.indexOf(tri_2) != -1) {
					return arr.get(arr.indexOf(tri_2));
				}
			}
			return 0;
			
			
		}
		return 0;
	}
}
