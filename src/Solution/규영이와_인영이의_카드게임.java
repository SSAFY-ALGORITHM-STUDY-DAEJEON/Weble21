package Solution;

import java.io.*;
import java.util.*;

public class 규영이와_인영이의_카드게임 {
	static int[] gyue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for(int tc = 1; tc <= n; tc++) {
			gwin = 0;
			iwin = 0;
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			gyue = new int[9];
			ArrayList<Integer> inn = new ArrayList<>();
			
			for (int i = 0; i < 9; i++) {
				gyue[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= 18; i++) {
				boolean flag = true;
				for(int j = 0; j<9; j++) {
					if(gyue[j] == i) {
						flag = false;
						break;
					}
				}
				if(flag) {
					inn.add(i);
				}
				
			}
			int[] sel = new int[9];
			recursive(inn, sel, 0, new boolean[9]);
			
			System.out.println("#" + tc + " " + gwin + " " + iwin);
		}
		
	}

	private static void recursive(ArrayList<Integer> inn, int[] sel, int k, boolean[] v) {
		// basis part
		if(k == sel.length) {
			// System.out.println(Arrays.toString(sel));
			game(sel);
			
			return;
		}
		
		// inductive part
		for(int i = 0; i<inn.size(); i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = inn.get(i);
				recursive(inn, sel, k+1, v);
				v[i] = false;
			}
		}
		
	}
	static int gwin = 0;
	static int iwin = 0;

	private static void game(int[] sel) {
		// TODO Auto-generated method stub
		int gsum = 0;
		int isum = 0;
		
		
		for(int i = 0; i < 9; i++) {
			if(gyue[i] > sel[i]) {
				gsum = gsum + sel[i] + gyue[i];
			} else {
				isum = isum + sel[i] + gyue[i];
			}
		}
		
		if(gsum > isum) {
			gwin++;
		} else if(gsum < isum) {
			iwin++;
		} else {
			gwin++;
			iwin++;
		}
		
	}
}
